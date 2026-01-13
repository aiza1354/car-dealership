import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    private List<Vehicle> vehicles;

    public VehicleInventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> filter(Double maxPrice, Integer maxMileage, String fuel) {
        List<Vehicle> filteredVehicleList = new ArrayList<>();

        for (Vehicle v : vehicles) {
            boolean priceMatch = (maxPrice == null || v.getPrice() <= maxPrice);
            boolean mileageMatch = (maxMileage == null || v.getMileage() <= maxMileage);
            boolean fuelMatch = (fuel == null || v.getFuelType().equalsIgnoreCase(fuel));
            if (priceMatch && mileageMatch && fuelMatch) {
                filteredVehicleList.add(v);
            }
        }
        return filteredVehicleList;
    }
    public double getTotalValue() {
        double totalValue = 0.0;
        for (Vehicle v : vehicles) {
            totalValue += v.getPrice();
        }
        return totalValue;
    }

    public void displayVehiclesInStock() {
        for (Vehicle vehicle : vehicles) {
            System.out.println("Year: " + vehicle.getYear() + " , Make: " +
                    vehicle.getMake() + " , Model: " +
                    vehicle.getModel());
        }
    }

}
