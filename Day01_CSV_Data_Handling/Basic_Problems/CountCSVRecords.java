package com.Week5.Day01_CSV_Data_Handling.Basic_Problems;
import java.io.*;

// Create CountCSVRecords class to count the CSV records while reading a file
class CountCSVRecords {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Employees.csv";

        int recordCount = 0;
        boolean isHeader = true;

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                recordCount++;
            }

            System.out.println("Total number of records: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

