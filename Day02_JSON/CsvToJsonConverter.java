package com.Week5.Day02_JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

// Create CsvToJsonConverter class to convert CSV data to JSON format
class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // Read CSV file content as a string
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/org/Employees.csv")));

            // Split CSV into lines
            String[] lines = content.split("\n");

            // Extract headers from first line
            String[] headers = lines[0].split(",");

            // Create JSON array to hold JSON objects
            JSONArray jsonArray = new JSONArray();

            // Process each line (excluding headers)
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");

                // Create JSON object for each row
                JSONObject jsonObject = new JSONObject();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j].trim(), values[j].trim());
                }

                // Add JSON object to JSON array
                jsonArray.put(jsonObject);
            }

            // Print converted JSON
            System.out.println("Converted JSON:");
            System.out.println(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
