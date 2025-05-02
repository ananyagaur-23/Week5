package advanced;
import java.util.*;
import java.io.*;

public class ConvertCSV {
	public static void main(String[] args) {
		String csvFile = "students.csv";
		String line;
		String delimiter = ",";
		List<Student> studentList = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			br.readLine();
			while((line = br.readLine()) != null) {
				String[] columns = line.split(delimiter);
				if(columns.length < 3){
					System.out.println("Skipping incomplete row: "+line);
					continue;
				}
				String name = columns[0].trim();
				String email = columns[1].trim();
				String phone = columns[2].trim();
				Student student = new Student(name, email, phone);
				studentList.add(student);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		for(Student s : studentList) {
			System.out.println(s);
		}
	}
}
class Student{
	private String name;
	private String email;
	private String phone;
	public Student(String name, String email, String phone){
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public String toString() {
		return "Student{name='" + name + "', email='" + email + "', phone='" + phone + "'}";
	}
}
