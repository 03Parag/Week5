
package com.Week5.Day01_CSV_Data_Handling.Advanced_Problems;


import java.io.*;
import java.sql.*;

class GenerateCSVReportfromDatabase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/My_database";
        String username = "username";
        String password = "password";
        String csvFile = "src/main/java/org/Employeesdatabase.csv";

        String sql = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Write header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Write data rows
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + dept + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV file created successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
