package practice;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Arrays;

public class StudentJsonCreator {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Ananya Gaur");
        student.put("age", 21);

        JSONArray subjects = new JSONArray(Arrays.asList("Mathematics", "Computer Science", "English"));
        student.put("subjects", subjects);

        System.out.println(student.toString(2));
    }
}
