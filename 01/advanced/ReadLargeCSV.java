package advanced;
import java.util.*;
import java.io.*;

public class ReadLargeCSV {
	public static void main(String[] args) {
		String csvFile = "largeFile.csv";
		int chunkSize = 100;
		int totalCount = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            List<String> chunk = new ArrayList<>();

            br.readLine();
            while ((line = br.readLine()) != null) {
                chunk.add(line);
                if (chunk.size() == chunkSize) {
                    processChunk(chunk);
                    totalCount += chunk.size();
                    System.out.println("Processed records: " + totalCount);
                    chunk.clear();
                }
            }
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalCount += chunk.size();
                System.out.println("Processed records: " + totalCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void processChunk(List<String> lines) {
        for (String line : lines) {
        }
	}
}
