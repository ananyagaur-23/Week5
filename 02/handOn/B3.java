package handOn;

import org.json.JSONArray;
import org.json.JSONObject;

public class B3{
    public static void main(String[] args) {
        String json = "["
            + "{\"name\":\"Ananya\",\"email\":\"ananya@example.com\",\"age\":21},"
            + "{\"name\":\"John\",\"email\":\"john@example.com\",\"age\":28},"
            + "{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":30}"
            + "]";

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            int age = user.getInt("age");

            if (age > 25) {
                System.out.println("Name: " + user.getString("name"));
                System.out.println("Email: " + user.getString("email"));
                System.out.println("Age: " + age);
                System.out.println();
            }
        }
    }
}
