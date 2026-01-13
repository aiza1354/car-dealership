public class Car extends Vehicle {
    public String bodyType;
    public String gearbox;
    public String engine;


    Car(int id, String make, String model, int year, int price, int mileage, String fuelType, String colour) {
        super(id,  make, model, year, price, mileage, fuelType, colour);

        //todo: bodyType,gearbox,engine
    }
}
