package handOn;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class B2{
    private String make;
    private String model;
    private int year;

    public B2(String make, String model, int year) {
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
        List<B2> cars = new ArrayList<>();
        cars.add(new B2("Toyota", "Camry", 2021));
        cars.add(new B2("Honda", "Civic", 2022));
        cars.add(new B2("Ford", "Mustang", 2023));

        JSONArray jsonArray = new JSONArray();
        for (B2 car : cars) {
            jsonArray.put(car.toJson());
        }

        System.out.println(jsonArray.toString());
    }
}
