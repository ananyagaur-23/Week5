package handOn;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class B1 {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(new File("data.json").toPath()));

            JSONObject jsonObject = new JSONObject(content);

            printKeysAndValues(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printKeysAndValues(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                System.out.println("Key: " + key + " (Nested Object)");
                printKeysAndValues((JSONObject) value);
            } else if (value instanceof JSONArray) {
                System.out.println("Key: " + key + " (Array of Objects)");
                for (int i = 0; i < ((JSONArray) value).length(); i++) {
                    printKeysAndValues(((JSONArray) value).getJSONObject(i));
                }
            } else {
                System.out.println("Key: " + key + ", Value: " + value);
            }
        }
    }
}
