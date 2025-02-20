package com.Week5.Day02_JSON;
import org.json.JSONObject;

// Create MergeJsonObjects class to merge 2 JSON object into one
class MergeJsonObjects {
    public static void main(String[] args) {
        // Create first JSON Object and put element
        JSONObject json1 = new JSONObject();
        json1.put("name", "Amit Sharma");
        json1.put("email", "amit.sharma@example.com");

        // Create second JSON Object and put element
        JSONObject json2 = new JSONObject();
        json2.put("age", 30);
        json2.put("city", "Mumbai");

        // Merge json2 into json1
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        // Print merged JSON object
        System.out.println(json1);
    }
}

