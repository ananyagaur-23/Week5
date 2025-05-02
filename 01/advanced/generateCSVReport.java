package advanced;
import java.util.*;
import java.io.*;
import java.sql.*;

public class generateCSVReport {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/your_database"; 
        String user = "your_username";                            
        String password = "your_password";                       
        String outputFile = "employees.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(String.format("%d,%s,%s,%.2f", id, name, dept, salary));
                writer.newLine();
            }

            System.out.println("CSV report generated: " + outputFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
	}
}
