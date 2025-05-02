package handOn;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ObjectListToJsonArrayConverter  {
    private String make;
    private String model;
    private int year;

    public ObjectListToJsonArrayConverter  (String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("make", make);
        jsonObject.put("model", model);
        jsonObject.put("year", year);
        return jsonObject;
    }
}

class Main {
    public static void main(String[] args) {
        List<ObjectListToJsonArrayConverter  > cars = new ArrayList<>();
        cars.add(new ObjectListToJsonArrayConverter  ("Toyota", "Camry", 2021));
        cars.add(new ObjectListToJsonArrayConverter  ("Honda", "Civic", 2022));
        cars.add(new ObjectListToJsonArrayConverter  ("Ford", "Mustang", 2023));

        JSONArray jsonArray = new JSONArray();
        for (ObjectListToJsonArrayConverter   car : cars) {
            jsonArray.put(car.toJson());
        }

        System.out.println(jsonArray.toString());
    }
}
