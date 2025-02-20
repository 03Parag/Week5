package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;
import java.io.*;
import java.util.*;

// Create Student class to convert student csv file into java objects
class Student {
    // Attributes of Student
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor for student
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Method to display student details
    public void print() {
        System.out.printf("ID: %d | Name: %-15s | Age: %d | Marks: %.2f%n", id, name, age, marks);
    }
}

// CSVToStudentList class
class CSVToStudentList {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "src/main/java/org/Students.csv";
        List<Student> studentList = new ArrayList<>();

        // Create an instance of buffered reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());

                    studentList.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the list of students
        System.out.println("\nStudent List:");
        System.out.println("------------------------------------------");
        for (Student student : studentList) {
            student.print();
        }
    }
}

