package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;
import java.io.*;
import java.util.regex.*;

// Create ValidateCSVData class to validate email and phone number
class ValidateCSVData {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Employee.csv";

        // Enter the regex patterns
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String phoneRegex = "^[0-9]{10}$";

        // Compile the pattern
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        boolean isHeader = true;

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Validating CSV Data\n");

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (data.length < 5) {
                    System.out.println("Invalid Row (Missing Fields): " + line);
                    continue;
                }

                String name = data[1].trim();
                String email = data[3].trim();
                String phone = data[4].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid) {
                    System.out.println("Invalid Email: " + email + " (Row: " + line + ")");
                }
                if (!isPhoneValid) {
                    System.out.println("Invalid Phone Number: " + phone + " (Row: " + line + ")");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

