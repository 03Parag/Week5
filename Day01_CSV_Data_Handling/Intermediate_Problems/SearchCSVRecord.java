package com.Week5.Day01_CSV_Data_Handling.Intermediate_Problems;
import java.io.*;
import java.util.Scanner;

// Create SearchCSVRecord class to search for an employee by name and print their department and salary
class SearchCSVRecord {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "employees.csv";

        // Create an input object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = input.nextLine().trim();

        boolean found = false;

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
                    String name = data[1].trim();
                    String department = data[2].trim();
                    String salary = data[3].trim();

                    if (name.equalsIgnoreCase(searchName)) {
                        System.out.println("Employee Found:");
                        System.out.println("Department: " + department);
                        System.out.println("Salary: Rs" + salary);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Close the input object
        input.close();
    }
}
