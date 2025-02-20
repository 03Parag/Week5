package com.Week5.Day01_CSV_Data_Handling.Basic_Problems;
import java.io.*;

// Create WriteCSVFile class to write data in a CSV file
class WriteCSVFile {
    public static void main(String[] args) {
        // Enter the CSV file name
        String filePath = "src/main/java/org/Employees.csv";

        // Create a employees array
        String[] employees = {
                "101,Rahul Singh,IT,60000",
                "102,Priya Sharma,HR,55000",
                "103,Amit Joshi,Finance,65000",
                "104,Rishi Rao,Marketing,62000",
                "105,Vikram Desai,Operations,58000"
        };

        // Create an instance of buffered writer
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            bufferedWriter.write("ID,Name,Department,Salary");
            bufferedWriter.newLine();

            for (String employee : employees) {
                bufferedWriter.write(employee);
                bufferedWriter.newLine();
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

