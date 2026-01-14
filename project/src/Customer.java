import java.util.ArrayList;

public class Customer extends Person{

    private ArrayList<Vehicle> purchaseHistory;
    public Customer (String name, String gender, int age, String position){
        super(name, gender, age, position);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.purchaseHistory = new ArrayList<>();
    }

    public void addPurchaseHistory(Vehicle vehicle) {
        this.purchaseHistory.add(vehicle);
    }

    public ArrayList<Vehicle> getPurchaseHistory() {
        return purchaseHistory;
    }
}
