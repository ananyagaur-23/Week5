package advanced;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

public class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonElements.put(annotation.name(), String.valueOf(field.get(obj)));
            }
        }
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        if (json.charAt(json.length() - 1) == ',') json.deleteCharAt(json.length() - 1);
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("ananya", "ananya@example.com");
        System.out.println(toJson(user));
    }
}
