package katas.exercises;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

public class ETLTask {

    public static void performETL(String sourceDbPath, String targetDbPath) throws SQLException {
        try (Connection sourceConn = DriverManager.getConnection("jdbc:sqlite:" + sourceDbPath);
             Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + targetDbPath);
             Statement sourceStmt = sourceConn.createStatement()) {

            // Create the target table if it doesn't exist
            try (Statement targetStmt = targetConn.createStatement()) {
                targetStmt.execute("CREATE TABLE IF NOT EXISTS transformed_users (" +
                        "user_id INTEGER PRIMARY KEY, " +
                        "full_name TEXT NOT NULL, " +
                        "email TEXT NOT NULL, " +
                        "age_group TEXT, " +
                        "years_registered INTEGER)");
            }

            ResultSet rs = sourceStmt.executeQuery("SELECT * FROM users");
            String insertSql = "INSERT OR IGNORE INTO transformed_users (user_id, full_name, email, age_group, years_registered) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement insertStmt = targetConn.prepareStatement(insertSql)) {
                while (rs.next()) {
                    try {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        int age = rs.getInt("age");
                        String registrationDate = rs.getString("registration_date");

                        String ageGroup = getAgeGroup(age);
                        int yearsRegistered = calculateYearsRegistered(registrationDate);

                        // Check for existing row
                        String checkSql = "SELECT COUNT(*) FROM transformed_users WHERE user_id = ?";
                        try (PreparedStatement checkStmt = targetConn.prepareStatement(checkSql)) {
                            checkStmt.setInt(1, id);
                            ResultSet rsCheck = checkStmt.executeQuery();
                            if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                                System.err.println("Duplicate user_id detected: " + id);
                                continue; // Skip duplicate
                            }
                        }

                        insertStmt.setInt(1, id);
                        insertStmt.setString(2, name);
                        insertStmt.setString(3, email);
                        insertStmt.setString(4, ageGroup);
                        insertStmt.setInt(5, yearsRegistered);

                        insertStmt.executeUpdate();
                    } catch (Exception e) {
                        System.err.println("Error processing row: " + e.getMessage());
                    }
                }
            }
        }
    }

    private static String getAgeGroup(int age) {
        if (age < 30) {
            return "Under 30";
        } else if (age <= 60) {
            return "30-60";
        } else {
            return "60+";
        }
    }

    private static int calculateYearsRegistered(String registrationDate) {
        try {
            LocalDate currentDate = LocalDate.now();
            LocalDate registerDate = LocalDate.parse(registrationDate);
            return Period.between(registerDate, currentDate).getYears();
        } catch (Exception e) {
            System.err.println("Invalid registration date format: " + registrationDate);
            return 0;
        }
    }

    public static void main(String[] args) throws SQLException {
        String sourceDb = "source.db";
        String targetDb = "target.db";

        performETL(sourceDb, targetDb);
        System.out.println("ETL process completed!");
    }
}
