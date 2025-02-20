package com.Week5.Day02_JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.IOException;

// Create ValidateEmailWithSchema class to validate email with schema
class ValidateEmailWithSchema {
    public static void main(String[] args) {
        // Define JSON Schema
        String schemaString = "{"
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "    \"rajesh.kumar@gmail.com\": {"
                + "        \"type\": \"string\","
                + "        \"format\": \"rajesh.kumar@gmail.com\""
                + "    }"
                + "},"
                + "\"required\": [\"rajesh.kumar@gmail.com\"]"
                + "}";

        // JSON object to validate
        String jsonString = "{ \"rajesh.kumar@gmail.com\": \"rajesh.kumargmail@.com\" }";

        try {
            // Load Schema and JSON Data
            JsonNode schemaNode = JsonLoader.fromString(schemaString);
            JsonNode jsonNode = JsonLoader.fromString(jsonString);

            // Load Schema
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema = factory.getJsonSchema(schemaNode);

            // Validate JSON against Schema
            ProcessingReport report = new ListProcessingReport();
            report = jsonSchema.validate(jsonNode);

            if (report.isSuccess()) {
                System.out.println("Email is valid!");
            } else {
                System.out.println("Invalid email: " + report);
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
