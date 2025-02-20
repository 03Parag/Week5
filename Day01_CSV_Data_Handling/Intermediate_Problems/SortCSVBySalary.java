package com.Week5.Day01_CSV_Data_Handling.Intermediate_Problems;
import java.io.*;
import java.util.*;

// Create SortCSVBySalary class to sort the records by Salary in descending order and print top 5 salaries
class SortCSVBySalary {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Employees.csv";

        List<String[]> employeeRecords = new ArrayList<>();
        boolean isHeader = true;
        String[] header = null;

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    header = data;
                    isHeader = false;
                } else if (data.length == 4) {
                    employeeRecords.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employeeRecords.sort((a, b) -> {
            double salaryA = Double.parseDouble(a[3].trim());
            double salaryB = Double.parseDouble(b[3].trim());
            return Double.compare(salaryB, salaryA);
        });

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        System.out.printf("%-5s %-15s %-15s %-10s%n", header[0], header[1], header[2], header[3]);

        int count = Math.min(5, employeeRecords.size());
        for (int i = 0; i < count; i++) {
            String[] emp = employeeRecords.get(i);
            System.out.printf("%-5s %-15s %-15s Rs%-10s%n", emp[0], emp[1], emp[2], emp[3]);
        }
    }
}

