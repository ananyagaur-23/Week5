package practice;

public class A4 {
    public static void main(String[] args) {
        String json1 = "{\"name\":\"Ananya Gaur\",\"email\":\"ananya@example.com\"}";
        String json2 = "{\"city\":\"Mumbai\",\"age\":21}";

        String merged = mergeJson(json1, json2);
        System.out.println(merged);
    }

    public static String mergeJson(String json1, String json2) {
        json1 = json1.trim();
        json2 = json2.trim();

        if (json1.endsWith("}")) json1 = json1.substring(0, json1.length() - 1);
        if (json2.startsWith("{")) json2 = json2.substring(1);

        return "{" + json1 + "," + json2 + "}";
    }
}
