package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;
import java.io.*;
import java.util.*;

// Create DetectDuplicateCSV class to find and print the duplicate record by ID
class DetectDuplicateCSV {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Duplicate.csv";
        Set<Integer> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (data.length > 0) {
                    int id = Integer.parseInt(data[0].trim());

                    if (!uniqueIds.add(id)) {
                        duplicateRecords.add(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!duplicateRecords.isEmpty()) {
            System.out.println("\nDuplicate Records Found:");
            for (String record : duplicateRecords) {
                System.out.println(record);
            }
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}

