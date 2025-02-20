package com.Week5.Day02_JSON;
import org.json.JSONObject;

// Create Cae class to convert object into JSON
class Car {
    // Attributes of car
    private String brand;
    private String model;
    private int year;

    // Constructor for car
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Convert car object to JSON
    public JSONObject toJson() {
        // Create JSON object and put element
        JSONObject json = new JSONObject();
        json.put("brand", brand);
        json.put("model", model);
        json.put("year", year);
        return json;
    }

    public static void main(String[] args) {
        // Create car object
        Car car = new Car("Toyota", "Corolla", 2022);

        // Convert car to JSON and print it
        JSONObject carJson = car.toJson();
        System.out.println(carJson.toString());
    }
}

