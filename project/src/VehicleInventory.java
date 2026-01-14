import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // created a filterest list, so that customers can input the desired range for various variables.
    // the function loops through Vehicles and finds the vehicles that match the input and adds them to a new array list called filteredList.
    // this arraylist will only show the cars that are suited to the filters that have been put in place.
    public List<Vehicle> filter(Double maxPrice, Integer maxMileage, String fuel) {
        ArrayList<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            boolean priceMatch = (maxPrice == null || vehicle.price <= maxPrice);
            boolean mileageMatch = (maxMileage == null || vehicle.mileage <= maxMileage);
            boolean fuelMatch = (fuel == null || vehicle.fuelType.equals(fuel));
            if (priceMatch && mileageMatch && fuelMatch) {
                filteredList.add(vehicle);
            } else {
                return null;
            }
        } return filteredList;

    }
    public List<Vehicle> search(int year, String make, String colour) {
        ArrayList<Vehicle> searchList = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            boolean yearMatch = (year == 0 || vehicle.year == year  );
            boolean makeMatch = (make == null || vehicle.make.equals(make));
            boolean colourMatch = (colour == null || vehicle.colour.equals(colour));
            if (yearMatch && makeMatch && colourMatch) {
                searchList.add(vehicle);
            }
        }
        return searchList;
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
            System.out.println("Year: " + vehicle.getYear() + " , Make: " + vehicle.getMake() + " , Model: " +  vehicle.getModel() + " Price: " + vehicle.getPrice() +" Mileage: " + vehicle.getMileage() + " Fuel Type: " + vehicle.getFuelType() + " Colour: " + vehicle.getColour() + "\n");;
        }
    }

    public void saveInventoryToCSV(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Type,Year,Make,Model,Price,Mileage,FuelType");
            for (Vehicle vehicle : vehicles) {
                String type = vehicle.getClass().getSimpleName();
                String line = type + "," +
                        vehicle.getYear() + "," +
                        vehicle.getMake() + "," +
                        vehicle.getModel() + "," +
                        vehicle.getPrice() + "," +
                        vehicle.getMileage() + "," +
                        vehicle.getFuelType();
                writer.write(line);
            }

            System.out.println("Inventory successfully saved to: " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while saving: " + e.getMessage());
        }
    }

}
