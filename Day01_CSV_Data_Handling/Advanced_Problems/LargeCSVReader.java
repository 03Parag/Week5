package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;
import java.io.*;

// Create LargeCSVReader class to process only 100 lines at a time and display the count of records processed
class LargeCSVReader {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/LargeCSVfile.csv";
        int batchSize = 100;
        int totalRecordsProcessed = 0;

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int batchCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                batchCount++;
                totalRecordsProcessed++;

                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecordsProcessed + " records...");
                    batchCount = 0;
                }
            }

            System.out.println("Finished processing. Total records: " + totalRecordsProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
