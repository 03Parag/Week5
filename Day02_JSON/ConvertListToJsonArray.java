package com.Week5.Day02_JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;

// Create ConvertListToJsonArray class to convert a list of Java objects into a JSON array
class ConvertListToJsonArray {
    // Person class
    static class Person {
        // Attributes of Person
        private String name;
        private int age;
        private String city;

        // Constructor for person
        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        // Method to get name
        public String getName() {
            return name;
        }

        // Method to get age
        public int getAge() {
            return age;
        }

        // Method to get city
        public String getCity() {
            return city;
        }
    }

    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Amit Sharma", 30, "Mumbai"),
                new Person("Priya Verma", 27, "Delhi"),
                new Person("Rajesh Kumar", 35, "Bangalore"),
                new Person("Sneha Iyer", 29, "Chennai"),
                new Person("Vikram Choudhary", 32, "Kolkata")
        );

        // Create an instance of Object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert list to JSON array
            String jsonArray = objectMapper.writeValueAsString(people);

            // Print JSON output
            System.out.println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


