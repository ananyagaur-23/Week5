package q;
import java.io.*;

public class ReadCSV {
	public static void main(String[] args) {
		String filePath = "students.csv";
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			br.readLine();
			while((line = br.readLine())!= null) {
				String[] data = line.split(",");
				System.out.println("ID: "+data[0]);
				System.out.println("Name: "+data[1]);
				System.out.println("Age: "+data[2]);
				System.out.println("Marks: "+data[3]);
				System.out.println("-----------------------");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
