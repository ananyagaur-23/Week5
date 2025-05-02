package intemediate;
import java.io.*;

public class ModifyCSV {
	public static void main(String[] args) {
		String inputFile = "employees.csv";
		String outputFile = "updated_employees.csv";
		try(
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			FileWriter writer = new FileWriter(outputFile);			
		){
			String header = br.readLine();
			writer.write(header + "\n");
			String line;
			while((line = br.readLine())!= null) {
				String[] data = line.split(",");
				if(data[2].equalsIgnoreCase("IT")) {
					double salary = Double.parseDouble(data[3]);
					salary *= 1.10;
					data[3] = String.format("%.2f", salary);
				}
				writer.write(String.join(",", data) +"\n");
			}
			System.out.println("Updated data written to " + outputFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}