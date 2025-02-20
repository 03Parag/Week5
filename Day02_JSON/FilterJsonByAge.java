package com.Week5.Day02_JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Create FilterJsonByAge class to filter the file where age is greater than 25
class FilterJsonByAge {
    public static void main(String[] args) {
        // Enter the file path
        File filePath = new File("src/main/java/org/Person.json");

        // Create an instance of Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON array from file
            JsonNode jsonNode = objectMapper.readTree(filePath);

            // Loop through the array and filter by age
            System.out.println("[");
            boolean first = true;
            for (JsonNode node : jsonNode) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    if (!first) System.out.println(",");
                    System.out.print(node.toString());
                    first = false;
                }
            }
            System.out.println("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

