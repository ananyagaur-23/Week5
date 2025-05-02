package advanced;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, Object> fieldMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            fieldMap.put(field.getName(), value);
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
            if (entry.getValue() != null) {
                json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
            } else {
                json.append("\"").append(entry.getKey()).append("\":null,");
            }
        }
        if (json.charAt(json.length() - 1) == ',') json.deleteCharAt(json.length() - 1);
        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Alice", 25);
        System.out.println(toJson(person));
    }
}
