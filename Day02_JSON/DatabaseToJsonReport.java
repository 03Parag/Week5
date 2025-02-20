package com.Week5.Day02_JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

// Create DatabaseToJsonReport class to fetch records and generate JSON report
class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Database";
        String user = "user";
        String password = "my_password";

        // Query to fetch all employee records
        String query = "SELECT * FROM Employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Create JSON Array to store employee records
            JSONArray jsonArray = new JSONArray();

            while (rs.next()) {
                JSONObject employeeJson = new JSONObject();
                employeeJson.put("id", rs.getInt("id"));
                employeeJson.put("name", rs.getString("name"));
                employeeJson.put("email", rs.getString("email"));
                employeeJson.put("age", rs.getInt("age"));
                employeeJson.put("department", rs.getString("department"));

                jsonArray.put(employeeJson);
            }

            // Print JSON report
            System.out.println("Generated JSON Report:");
            System.out.println(jsonArray);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

