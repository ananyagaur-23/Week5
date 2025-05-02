package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonFieldExtractor  {
    public static void main(String[] args) {
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("data.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = jsonContent.toString().replaceAll("\\s+", "");

        String name = extractValue(json, "name");
        String email = extractValue(json, "email");

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    private static String extractValue(String json, String key) {
        String pattern = "\"" + key + "\":\"";
        int start = json.indexOf(pattern);
        if (start == -1) return "Not found";
        start += pattern.length();
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}
