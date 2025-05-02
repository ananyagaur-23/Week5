package practice;

import java.util.ArrayList;
import java.util.List;

public class JavaObjectListToJsonArrayConverter  {
    private String make;
    private String model;
    private int year;

    public JavaObjectListToJsonArrayConverter (String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toJson() {
        return "{"
            + "\"make\":\"" + make + "\","
            + "\"model\":\"" + model + "\","
            + "\"year\":" + year
            + "}";
    }
}

class Main {
    public static void main(String[] args) {
        List<JavaObjectListToJsonArrayConverter > cars = new ArrayList<>();
        cars.add(new JavaObjectListToJsonArrayConverter ("Toyota", "Camry", 2021));
        cars.add(new JavaObjectListToJsonArrayConverter ("Honda", "Civic", 2022));
        cars.add(new JavaObjectListToJsonArrayConverter ("Ford", "Mustang", 2023));

        StringBuilder jsonArray = new StringBuilder("[");
        for (int i = 0; i < cars.size(); i++) {
            jsonArray.append(cars.get(i).toJson());
            if (i < cars.size() - 1) {
                jsonArray.append(",");
            }
        }
        jsonArray.append("]");

        System.out.println(jsonArray.toString());
    }
}
