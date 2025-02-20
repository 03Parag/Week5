package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;
import java.io.*;
import java.util.*;

// Create 2 csv files and merge them
class MergeCSVFiles {
    public static void main(String[] args) {
        // Enter the file path
        String file1 = "src/main/java/org/Students1.csv";
        String file2 = "src/main/java/org/Students2.csv";
        String outputFile = "src/main/java/org/Merged_students.csv";

        Map<Integer, String[]> studentMap = new HashMap<>();

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String age = data[2].trim();
                    studentMap.put(id, new String[]{name, age, "", ""});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    String marks = data[1].trim();
                    String grade = data[2].trim();

                    if (studentMap.containsKey(id)) {
                        studentMap.get(id)[2] = marks;
                        studentMap.get(id)[3] = grade;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an instance of buffered reader
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            bufferedWriter.write("ID,Name,Age,Marks,Grade\n");

            for (Map.Entry<Integer, String[]> entry : studentMap.entrySet()) {
                int id = entry.getKey();
                String[] details = entry.getValue();
                bufferedWriter.write(id + "," + details[0] + "," + details[1] + "," + details[2] + "," + details[3] + "\n");
            }

            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

