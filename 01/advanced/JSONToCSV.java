package advanced;
import java.util.*;
import java.io.*;
import org.json.*;

public class JSONToCSV {
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONArray jsonArray = new JSONArray(sb.toString());

            JSONObject first = jsonArray.getJSONObject(0);
            List<String> headers = new ArrayList<>(first.keySet());
            writer.write(String.join(",", headers));
            writer.newLine();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                List<String> row = new ArrayList<>();
                for (String key : headers) {
                    row.add(obj.get(key).toString());
                }
                writer.write(String.join(",", row));
                writer.newLine();
            }

            System.out.println("JSON to CSV conversion complete.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {

            String line = reader.readLine();
            String[] headers = line.split(",");
            JSONArray jsonArray = new JSONArray();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(4));
            System.out.println("CSV to JSON conversion complete.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "students.json";
        String csvOutput = "students.csv";
        String jsonOutput = "students_converted.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}
