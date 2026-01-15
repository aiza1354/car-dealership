import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        CustomerRecords customerRecords = new CustomerRecords();

        Vehicle car1 = new Vehicle(1, "Mercedes-Benz", "CLA", 2017, 50000, 5000, "Diesel", "Black");
        Vehicle car2 = new Vehicle(2, "BMW", "24", 2009, 70000, 6000, "Diesel", "Pink");
        Vehicle car3 = new Vehicle(3, "Ford", "Sports", 2020, 30000, 8000, "Petrol", "Black");
        Vehicle car4 = new Vehicle(4, "Ford", "Fiesta", 2025, 20000, 7000, "Electric", "White");

        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(car4);

        VehicleInventory vehicleInventory = new VehicleInventory(vehicles);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Aiza Car Sales 🚘!");
        System.out.println("Here is a display of the cars we have in stock: ");
        vehicleInventory.displayVehiclesInStock();
        vehicleInventory.saveInventoryToCSV("Inventory.csv");
        System.out.println("Please give us your name.");
        String nameInput = scanner.nextLine();

        System.out.println("Your age.");
        int ageInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Your gender.");
        String genderInput = scanner.nextLine();

        Customer newCustomer = new Customer(nameInput, genderInput, ageInput, "Customer");
        customerRecords.addCustomer(newCustomer);

        System.out.println(newCustomer.getName() + " has been registered!");

        System.out.println("\nWhat would you like to do next? ");
        System.out.println("1: Search for a specific car.");
        System.out.println("2: Filter your search result.");
        System.out.println("3: Buy a Car.");
        System.out.println("4: Exit.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        boolean running = true;
        while (running) {
            switch (choice) {
                case 1:
                    showSearch(scanner, vehicleInventory);
                    break;
                case 2:
                    showFilterResult(scanner, vehicleInventory);
                    break;
                case 3:
                    buyCar(scanner, vehicleInventory, customerRecords);
                    break;
                case 4:
                    System.out.println("Bye");
                    running = false;
                    break;
            }
        }
    }

    private static void showSearch(Scanner scanner, VehicleInventory vehicleInventory) {
        System.out.println("Enter Year of the car");
        int yearInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Make of the car");
        String makeInput = scanner.nextLine();
        System.out.println("Enter Colour of the car");
        String colourInput = scanner.nextLine();

        List<Vehicle> searchList = vehicleInventory.search(yearInput, makeInput, colourInput);
        for (Vehicle i : searchList) {
            System.out.println("Year is: " + i.getYear() + " , Make: " + i.getMake() + " , Colour: " + i.getColour());
        }
    }

    private static void showFilterResult(Scanner scanner, VehicleInventory vehicleInventory) {
        System.out.println("Enter maximum price of the car");
        double priceInput = scanner.nextDouble();
        System.out.println("Enter maximum mileage of the car");
        int mileageInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter fuel type of the car (Petrol/Diesel/Electric)");
        String fuelInput = scanner.nextLine();

        List<Vehicle> filterList = vehicleInventory.filter(priceInput, mileageInput, fuelInput);
        for (Vehicle i : filterList) {
            System.out.println("Year is: " + i.getYear() + " , Make: " + i.getMake() + " , Colour: " + i.getColour());
        }
    }

    private static void buyCar(Scanner scanner, VehicleInventory vehicleInventory, CustomerRecords customerRecords) {
        List<Vehicle> currentInventory = vehicleInventory.getVehicles();

        for (Vehicle vehicle : currentInventory) {
            System.out.println("Id : " + vehicle.getId() + " Year: " + vehicle.getYear() + " , Make: " + vehicle.getMake() + " , Model: " + vehicle.getModel() + " Price: " + vehicle.getPrice() + " Mileage: " + vehicle.getMileage() + " Fuel Type: " + vehicle.getFuelType() + " Colour: " + vehicle.getColour());
        }

        System.out.println("Enter the Id of the car");
        int idInput = scanner.nextInt();
        scanner.nextLine();

        Vehicle selectedVehicle = null;
        for (Vehicle v : currentInventory) {
            if (v.getId() == idInput) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle != null) {
            System.out.print("Enter Customer Name for the receipt: ");
            String customerName = scanner.nextLine();
            Customer customer = customerRecords.findCustomerByName(customerName);

            if (customer != null) {
                currentInventory.remove(selectedVehicle);
                // add the selectedVehicle to customer purchaseHistory
                customer.addVehicleToHistory(selectedVehicle);
                System.out.println("\nReceipt:");
                System.out.println("Customer: " + customer.getName());
                System.out.println("Vehicle: " + selectedVehicle.getMake() + " " + selectedVehicle.getModel());
                System.out.println("Total: £" + selectedVehicle.getPrice());
            } else {
                System.out.println("Customer not found in records.");
            }
        }
    }
}