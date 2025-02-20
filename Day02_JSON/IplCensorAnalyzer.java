package com.Week5.Day02_JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

// Create IplCensorAnalyzer class that reads IPL match data from JSON and CSV files, processes the data based on defined censorship rules, and writes the sanitized data back to new files
class IplCensorAnalyzer {
    // Method to censor the team name
    private static String censorTeamName(String teamName) {
        List<String> words = Arrays.asList(teamName.split(" "));
        if (words.size() > 1) {
            return words.get(0) + " ***";
        }
        return teamName;
    }

    // Method to process JSON file
    private static void processJsonFile(String inputFile, String outputFile) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));
            JSONArray matches = new JSONArray(content);

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                // Apply censorship rules
                match.put("team1", censorTeamName(match.getString("team1")));
                match.put("team2", censorTeamName(match.getString("team2")));
                match.put("winner", censorTeamName(match.getString("winner")));
                match.put("player_of_match", "REDACTED");
            }

            // Write the censored JSON to a new file
            Files.write(Paths.get(outputFile), matches.toString(4).getBytes());
            System.out.println("Censored JSON saved to: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to process CSV file
    private static void processCsvFile(String inputFile, String outputFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            String line = bufferedReader.readLine();
            bufferedWriter.write(line + "\n");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                // Apply censorship rules
                data[1] = censorTeamName(data[1]);
                data[2] = censorTeamName(data[2]);
                data[5] = censorTeamName(data[5]);
                data[6] = "REDACTED";

                // Write sanitized line to the new CSV
                bufferedWriter.write(String.join(",", data) + "\n");
            }

            System.out.println("Censored CSV saved to: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/org/IPL_matches.json";
        String csvFilePath = "src/main/java/org/IPL_matches.csv";

        // Process JSON and CSV files
        processJsonFile(jsonFilePath, "src/main/java/org/Censored_IPL_matches.json");
        processCsvFile(csvFilePath, "src/main/java/org/Censored_IPL_matches.csv");
    }
}

