package com.Week5.Day02_JSON;
import org.json.JSONObject;
import org.json.XML;

// Create JsonToXmlConverter class to convert JSON to XML format
class JsonToXmlConverter {
    public static void main(String[] args) {
        // Create a JSON Object and put elements
        JSONObject json = new JSONObject();
        json.put("name", "Amit Sharma");
        json.put("email", "amit.sharma@example.com");
        json.put("age", 30);
        json.put("city", "Mumbai");

        // Convert JSON to XML
        String xml = XML.toString(json);

        // Print XML format
        System.out.println("Converted XML:" + xml);
    }
}

