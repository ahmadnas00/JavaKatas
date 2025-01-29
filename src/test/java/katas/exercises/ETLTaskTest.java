package katas.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class ETLTaskTest {

    private static final String SOURCE_DB = "source_test.db";
    private static final String TARGET_DB = "target_test.db";

    @BeforeEach
    public void setupDatabases() throws Exception {
        // Create a source database with sample data
        try (Connection sourceConn = DriverManager.getConnection("jdbc:sqlite:" + SOURCE_DB);
             Statement stmt = sourceConn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "age INTEGER, " +
                    "registration_date TEXT)");
            stmt.execute("DELETE FROM users"); // Clean up old data
            stmt.execute("INSERT INTO users (id, name, email, age, registration_date) VALUES " +
                    "(1, 'Elon Musk', 'elon@spacex.com', 52, '2002-12-01'), " +
                    "(2, 'Greta Thunberg', 'greta@climate.org', 20, '2018-08-20'), " +
                    "(3, 'Joe Biden', 'joe@whitehouse.gov', 81, '1972-11-05')");
        }

        // Create a target database with no data initially
        try (Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + TARGET_DB);
             Statement stmt = targetConn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS transformed_users (" +
                    "user_id INTEGER PRIMARY KEY, " +
                    "full_name TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "age_group TEXT, " +
                    "years_registered INTEGER)");
            stmt.execute("DELETE FROM transformed_users"); // Clean up old data
        }
    }

    @AfterEach
    public void cleanupDatabases() throws Exception {
        Files.deleteIfExists(Path.of(SOURCE_DB));
        Files.deleteIfExists(Path.of(TARGET_DB));
    }

    @Test
    public void testETLProcess() throws Exception {
        // Run the ETL process
        ETLTask.performETL(SOURCE_DB, TARGET_DB);

        // Verify the target database contains the transformed data
        try (Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + TARGET_DB);
             Statement stmt = targetConn.createStatement()) {
            var rs = stmt.executeQuery("SELECT * FROM transformed_users");

            assertTrue(rs.next());
            assertEquals(1, rs.getInt("user_id"));
            assertEquals("Elon Musk", rs.getString("full_name"));
            assertEquals("elon@spacex.com", rs.getString("email"));
            assertEquals("30-60", rs.getString("age_group"));
            assertEquals(22, rs.getInt("years_registered")); // Based on the current year

            assertTrue(rs.next());
            assertEquals(2, rs.getInt("user_id"));
            assertEquals("Greta Thunberg", rs.getString("full_name"));
            assertEquals("greta@climate.org", rs.getString("email"));
            assertEquals("Under 30", rs.getString("age_group"));
            assertEquals(6, rs.getInt("years_registered"));

            assertTrue(rs.next());
            assertEquals(3, rs.getInt("user_id"));
            assertEquals("Joe Biden", rs.getString("full_name"));
            assertEquals("joe@whitehouse.gov", rs.getString("email"));
            assertEquals("60+", rs.getString("age_group"));
            assertEquals(52, rs.getInt("years_registered"));

            assertFalse(rs.next());
        }
    }


}
