package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

class EncryptDecryptCSV {
    private static SecretKey secretKey;

    // Generate AES Key
    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // AES-128
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Encrypt Data
    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Decrypt Data
    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Write Encrypted CSV
    public static void writeEncryptedCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write Header
            writer.write("ID,Name,Department,Salary,Email");
            writer.newLine();

            // Sample Data (Encrypt Salary & Email)
            String[][] employees = {
                    {"101", "Alice", "IT", "75000", "alice@example.com"},
                    {"102", "Bob", "HR", "68000", "bob@example.com"},
                    {"103", "Charlie", "Finance", "82000", "charlie@example.com"}
            };

            for (String[] emp : employees) {
                writer.write(emp[0] + "," + emp[1] + "," + emp[2] + ","
                        + encrypt(emp[3]) + "," + encrypt(emp[4]));
                writer.newLine();
            }

            System.out.println("Encrypted CSV file created: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read & Decrypt CSV
    public static void readDecryptedCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    System.out.println(line); // Print Header
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length < 5) continue;

                // Decrypt Salary & Email
                System.out.println(values[0] + "," + values[1] + "," + values[2] + ","
                        + decrypt(values[3]) + "," + decrypt(values[4]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/java/org/Employees_encrypted.csv";

        writeEncryptedCSV(fileName);
        System.out.println("\nDecrypted Data:");
        readDecryptedCSV(fileName);
    }
}
