package handOn;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class B5 {
    public static void main(String[] args) {
        try {
            FileReader reader1 = new FileReader("file1.json");
            JSONObject jsonObject1 = new JSONObject(new JSONTokener(reader1));

            FileReader reader2 = new FileReader("file2.json");
            JSONObject jsonObject2 = new JSONObject(new JSONTokener(reader2));

            jsonObject1.put("merged", jsonObject2);

            System.out.println(jsonObject1.toString(4)); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
