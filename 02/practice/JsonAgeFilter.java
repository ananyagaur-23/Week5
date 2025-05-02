package practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.*;

class JsonAgeFilter {
    public String name;
    public String email;
    public int age;

    public JsonAgeFilter (String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        String json = "["
            + "{\"name\":\"Ananya\",\"email\":\"ananya@example.com\",\"age\":21},"
            + "{\"name\":\"John\",\"email\":\"john@example.com\",\"age\":28},"
            + "{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":30}"
            + "]";

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = (ArrayNode) mapper.readTree(json);

        ArrayList<JsonAgeFilter > filteredList = new ArrayList<>();
        for (JsonNode node : arrayNode) {
            int age = node.get("age").asInt();
            if (age > 25) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                filteredList.add(new Person(name, email, age));
            }
        }

        for (Person person : filteredList) {
            System.out.println("Name: " + person.name + ", Email: " + person.email + ", Age: " + person.age);
        }
    }
}
