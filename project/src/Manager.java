import java.util.ArrayList;

public class Manager extends Person {
    public Manager(String name, String gender, int age, String position) {
        super(name, gender, age, position);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }

    public void addVehicleToInventory(Vehicle vehicle, VehicleInventory inventory) {
        inventory.addVehicle(vehicle);
    }


}
