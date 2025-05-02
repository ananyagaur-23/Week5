package handOn;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter{
	public static void main(String[] args) {
        String jsonString = "{"
            + "\"name\": \"Ananya\","
            + "\"email\": \"ananya@example.com\","
            + "\"age\": 21,"
            + "\"city\": \"Mumbai\""
            + "}";

        JSONObject jsonObject = new JSONObject(jsonString);

        String xmlString = XML.toString(jsonObject);

        System.out.println(xmlString);
    }
}
