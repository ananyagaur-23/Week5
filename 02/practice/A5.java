package practice;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
    public String name;
    public String email;
    public int age;
}

public class A5 {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Ananya Gaur\", \"email\": \"ananya@example.com\", \"age\": 21 }";

        ObjectMapper mapper = new ObjectMapper();

        try {
            Person p = mapper.readValue(json, Person.class);
            System.out.println("JSON is valid and matches the structure.");
        } catch (Exception e) {
            System.out.println("Invalid JSON or structure mismatch.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
