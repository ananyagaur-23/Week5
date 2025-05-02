package intermediate;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "12345";
}

public class AccessAndModifyStaticFields {
    public static void main(String[] args) throws Exception {
        Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        apiKeyField.set(null, "67890");
        System.out.println("Modified API_KEY: " + apiKeyField.get(null));
    }
}
