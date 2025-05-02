package handOn;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class B4 {
    public static void main(String[] args) {
        try {
            InputStream schemaStream = B4.class.getResourceAsStream("/email-schema.json");
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(schemaJson);

            // Sample JSON data to validate
            String jsonString = "{\"email\": \"ananya@example.com\"}";
            JSONObject jsonObject = new JSONObject(jsonString);

            schema.validate(jsonObject);

            System.out.println("Email is valid!");
        } catch (ValidationException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }
}
