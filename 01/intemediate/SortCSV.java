package intemediate;
import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}

public class SortCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String line;
        List<Employee> employees = new ArrayList<>();
        
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            int id = Integer.parseInt(fields[0]);
            String name = fields[1];
            String department = fields[2];
            double salary = Double.parseDouble(fields[3]);
            employees.add(new Employee(id, name, department, salary));
        }

        br.close();

        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

        for (int i = 0; i < 5; i++) {
            System.out.println(employees.get(i));
        }
    }
}
