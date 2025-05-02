package advanced;
import java.util.*;
import java.io.*;

public class MergeCSV {
	public static void main(String[] args) {
		String file1 = "student1.csv";
		String file2 = "student2.csv";
		String outputFile = "merged_student.csv";
		Map<String,String[]> studentMap1 = new HashMap<>();
		Map<String,String[]> studentMap2 = new HashMap<>();
		
		try(
				BufferedReader br1 = new BufferedReader(new FileReader(file1));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			){
			String line;
			 br1.readLine(); 
	            while ((line = br1.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    studentMap1.put(parts[0], new String[]{parts[1], parts[2]});
	                }
	            }

	            br2.readLine(); 
	            while ((line = br2.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    studentMap2.put(parts[0], new String[]{parts[1], parts[2]});
	                }
	            }

	            writer.write("ID,Name,Age,Marks,Grade\n");

	            for (String id : studentMap1.keySet()) {
	                String[] info1 = studentMap1.get(id);
	                String[] info2 = studentMap2.get(id);

	                if (info2 != null) {
	                    writer.write(String.format("%s,%s,%s,%s,%s\n", id, info1[0], info1[1], info2[0], info2[1]));
	                }
	            }

	            System.out.println("Merged file created: " + outputFile);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}