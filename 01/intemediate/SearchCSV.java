package intemediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
