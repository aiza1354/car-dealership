import java.util.ArrayList;

public class Manager extends Person {
    public Manager(String name, String gender, int age, String position) {
        super(name, gender, age, position);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }

    public void addVehicleToInventory(Vehicle vehicle, ArrayList<Vehicle> vehicles) {
        vehicles.add(vehicle);
    }

    public String displayVehiclesInStock(Vehicle vehicle, ArrayList<Vehicle> vehicleDetails) {
        for (int i = 0; i < vehicleDetails.size(); i++) {
            System.out.println("Type of Vehicle");
        }
        return null;
    }

}
