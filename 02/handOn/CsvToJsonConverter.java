package handOn;

import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter{
    public static void main(String[] args) {
        try (CSVReader csvReader = new CSVReader(new FileReader("data.csv"))) {
            List<String[]> rows = csvReader.readAll();

            JSONArray jsonArray = new JSONArray();

            String[] headers = rows.get(0);

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                JSONObject jsonObject = new JSONObject();

                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }

                jsonArray.put(jsonObject);
            }

            System.out.println(jsonArray.toString(4)); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
