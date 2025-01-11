package katas.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitHubRepoActivityIntensity {
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos";

    public static List<Instant> fetchCommitTimestamps(String owner, String repo) throws Exception {
        List<Instant> timestamps = new ArrayList<>();
        String url = GITHUB_API_BASE_URL + "/" + owner + "/" + repo + "/commits";
        String nextUrl = url;

        while (nextUrl != null) {
            HttpURLConnection conn = (HttpURLConnection) new URL(nextUrl).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/vnd.github+json");

            // Check the response code
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed to fetch data: HTTP code " + conn.getResponseCode());
            }

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Extract commit timestamps using regex
            Pattern pattern = Pattern.compile("\\\"date\\\":\\\"(.*?)\\\"");
            Matcher matcher = pattern.matcher(response.toString());
            while (matcher.find()) {
                timestamps.add(Instant.parse(matcher.group(1)));
            }

            // Handle pagination
            String linkHeader = conn.getHeaderField("Link");
            nextUrl = null;
            if (linkHeader != null && linkHeader.contains("rel=\"next\"")) {
                for (String link : linkHeader.split(",")) {
                    if (link.contains("rel=\"next\"")) {
                        nextUrl = link.substring(link.indexOf("<") + 1, link.indexOf(">"));
                    }
                }
            }
        }

        return timestamps;
    }

    public static double calculateAverageTimeBetweenCommits(List<Instant> timestamps) {
        if (timestamps.size() < 2) {
            return 0.0; // Not enough data to calculate an average
        }

        timestamps.sort(Instant::compareTo);
        long totalDifferenceInSeconds = 0;

        for (int i = 1; i < timestamps.size(); i++) {
            totalDifferenceInSeconds +=
                    timestamps.get(i).getEpochSecond() - timestamps.get(i - 1).getEpochSecond();
        }

        double averageDifferenceInSeconds = (double) totalDifferenceInSeconds / (timestamps.size() - 1);
        return averageDifferenceInSeconds / 3600; // Convert seconds to hours
    }

    public static void main(String[] args) {
        try {
            List<Instant> timestamps = fetchCommitTimestamps("torvalds", "linux");
            double avgTime = calculateAverageTimeBetweenCommits(timestamps);

            System.out.printf("The average time between commits in the repository is %.2f hours.%n", avgTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
