package practice;

public class CarToJsonConverter  {
    private String make;
    private String model;
    private int year;
    private double price;

    public CarToJsonConverter (String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String toJson() {
        return "{"
            + "\"make\":\"" + make + "\","
            + "\"model\":\"" + model + "\","
            + "\"year\":" + year + ","
            + "\"price\":" + price
            + "}";
    }

    public static void main(String[] args) {
        CarToJsonConverter  car = new CarToJsonConverter ("Honda", "Civic", 2023, 21000.50);
        String json = car.toJson();
        System.out.println(json);
    }
}
