package IPLandCensorAnalyser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) {
        String jsonInputFile = "ipl_data.json";
        String csvInputFile = "ipl_data.csv";
        String jsonOutputFile = "ipl_data_censored.json";
        String csvOutputFile = "ipl_data_censored.csv";

        processJsonData(jsonInputFile, jsonOutputFile);

        processCsvData(csvInputFile, csvOutputFile);
    }

    private static void processJsonData(String inputFile, String outputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String jsonData = "";
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData += line;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject match = jsonArray.getJSONObject(i);

                match.put("team1", censorTeamName(match.getString("team1")));
                match.put("team2", censorTeamName(match.getString("team2")));

                match.put("player_of_match", "REDACTED");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(jsonArray.toString(4));
            writer.close();

            System.out.println("JSON Data Processed and Saved to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCsvData(String inputFile, String outputFile) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(inputFile));
            List<String[]> records = csvReader.readAll();
            csvReader.close();

            CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile));

            csvWriter.writeNext(records.get(0));

            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);

                record[1] = censorTeamName(record[1]);
                record[2] = censorTeamName(record[2]);

                record[6] = "REDACTED";

                csvWriter.writeNext(record);
            }

            csvWriter.close();
            System.out.println("CSV Data Processed and Saved to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String censorTeamName(String teamName) {
        return teamName.replaceAll("([A-Za-z]+)\\s([A-Za-z]+)", "$1 ***");
    }
}
