package com.Week5.Day02_JSON;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

// Create MergeJsonFiles class to merge two JSON files into one
class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Read JSON files
            String content1 = new String(Files.readAllBytes(Paths.get("src/main/java/org/File1.json")));
            String content2 = new String(Files.readAllBytes(Paths.get("src/main/java/org/File2.json")));

            // Convert strings to JSON Objects
            JSONObject json1 = new JSONObject(content1);
            JSONObject json2 = new JSONObject(content2);

            // Merge json2 into json1
            for (String key : json2.keySet()) {
                json1.put(key, json2.get(key));
            }

            // Print merged JSON object
            System.out.println(json1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
