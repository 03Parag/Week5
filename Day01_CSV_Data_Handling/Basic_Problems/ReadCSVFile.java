package com.Week5.Day01_CSV_Data_Handling.Basic_Problems;
import java.io.*;

// Create ReadCSVFile class to read CSV file and print it data
class ReadCSVFile {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Students.csv";

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());

                    System.out.printf("ID: %d | Name: %s | Age: %d | Marks: %.2f%n", id, name, age, marks);
                } else {
                    System.out.println("Skipping invalid row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

