package com.Week5.Day01_CSV_Data_Handling.Intermediate_Problems;
import java.io.*;
import java.util.*;

// Create UpdateCSVFile class to increase the IT department salary by 10%t
class UpdateCSVFile {
    public static void main(String[] args) {
        // Enter the input and output file path
        String inputFilePath = "src/main/java/org/Employees.csv";
        String outputFilePath = "src/main/java/org/Updated_employees.csv";

        List<String[]> employeeRecords = new ArrayList<>();

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                } else if (data.length == 4 && data[2].trim().equalsIgnoreCase("IT")) {

                    double salary = Double.parseDouble(data[3].trim());
                    salary *= 1.10;
                    data[3] = String.format("%.2f", salary);
                }

                employeeRecords.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an instance of buffered reader
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : employeeRecords) {
                bufferedWriter.write(String.join(",", record));
                bufferedWriter.newLine();
            }
            System.out.println("Updated CSV file saved as: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

