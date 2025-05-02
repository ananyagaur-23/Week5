package practice;

public class A2 {
    private String make;
    private String model;
    private int year;
    private double price;

    public A2(String make, String model, int year, double price) {
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
        A2 car = new A2("Honda", "Civic", 2023, 21000.50);
        String json = car.toJson();
        System.out.println(json);
    }
}
