package q;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Alice,HR,50000\n");
            writer.write("2,Bob,IT,60000\n");
            writer.write("3,Charlie,Finance,55000\n");
            writer.write("4,David,Marketing,52000\n");
            writer.write("5,Eve,Operations,58000\n");
            System.out.println("Data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}