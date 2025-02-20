package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;

import java.io.*;
import org.json.*;
import java.nio.file.*;
import java.util.*;

class JSONCSVConverter {

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            // Read JSON file as String
            String content = new String(Files.readAllBytes(Paths.get(jsonFile)));

            // Convert to JSONArray
            JSONArray students = new JSONArray(content);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                // Write CSV Header
                writer.write("ID,Name,Age,Marks");
                writer.newLine();

                // Write Data
                for (int i = 0; i < students.length(); i++) {
                    JSONObject student = students.getJSONObject(i);
                    writer.write(student.getInt("ID") + "," +
                            student.getString("Name") + "," +
                            student.getInt("Age") + "," +
                            student.getDouble("Marks"));
                    writer.newLine();
                }
            }

            System.out.println("CSV file created: " + csvFile);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                // Split CSV line by comma
                String[] values = line.split(",");
                if (values.length < 4) continue; // Skip malformed lines

                // Create JSON object
                JSONObject student = new JSONObject();
                student.put("ID", Integer.parseInt(values[0].trim()));
                student.put("Name", values[1].trim());
                student.put("Age", Integer.parseInt(values[2].trim()));
                student.put("Marks", Double.parseDouble(values[3].trim()));

                jsonArray.put(student);
            }

            // Write JSON Array to file
            Files.write(Paths.get(jsonFile), jsonArray.toString(4).getBytes());
            System.out.println("JSON file created: " + jsonFile);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFile = "src/main/java/org/Students.json";
        String csvFile = "src/main/java/org/Students.csv";
        String outputJsonFile ="src/main/java/org/Converted_students.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, outputJsonFile);
    }
}
