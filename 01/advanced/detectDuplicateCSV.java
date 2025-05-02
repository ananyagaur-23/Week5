package advanced;
import java.util.*;
import java.io.*;

public class detectDuplicateCSV {
	public static void main(String[] args) {
		String csvFile = "students.csv";
        String line;
        String delimiter = ",";
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                if (columns.length > 0) {
                    String id = columns[0].trim();
                    if (seenIds.contains(id)) {
                        duplicates.add(line);
                    } else {
                        seenIds.add(id);
                    }
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records based on ID:");
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
