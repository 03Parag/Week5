package com.Week5.Day02_JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Create ValidateJson class to validate JSON
class ValidateJson {
    public static void main(String[] args) {
        // Create an instance of Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file and parse it into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/org/Amit.json"));

            // Validate if required fields exist
            if (jsonNode.has("name") && jsonNode.has("email") && jsonNode.has("age") && jsonNode.has("city")) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON is invalid: Missing required fields.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

