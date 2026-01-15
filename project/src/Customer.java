import java.util.ArrayList;

public class Customer extends Person{

    private ArrayList<Vehicle> purchaseHistory;
    public Customer (String name, String gender, int age, String position){
        super(name, gender, age, position);
        this.purchaseHistory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addVehicleToHistory(Vehicle selectedVehicle) {
        purchaseHistory.add(selectedVehicle);
    }

}
