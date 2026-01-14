import java.util.ArrayList;
import java.util.List;

public class CustomerRecords {
    private ArrayList<Customer> allCustomers;

    public CustomerRecords() {
        this.allCustomers = new ArrayList<>();
    }

    // Adds a new customer to the records
    public void addCustomer(Customer customer) {
        allCustomers.add(customer);
        System.out.println("Customer " + customer.getName() + " has been registered.");
    }

    // Find a customer by name in the records
    public Customer findCustomerByName(String name) {
        for (Customer c : allCustomers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null; // Return null if not found
    }

    // Display all customers and what they bought
    public void displayAllRecords() {
        System.out.println("Customer Records: ");
        for (Customer customer: allCustomers) {
            System.out.println("Customer: " + customer.getName() + " | Age: " + customer.getAge());

            List<Vehicle> history = customer.getPurchaseHistory();
            if (history.isEmpty()) {
                System.out.println("  - No purchase history.");
            } else {
                for (Vehicle v : history) {
                    System.out.println("  - Bought: " + v.getYear() + " " + v.getMake());
                }
            }
            System.out.println("-------------------------");
        }
    }
}
