public class Vehicle {
    private int id;
    private String make;
    private String model;
    private int year;
    private int price;
    private int mileage;
    private String fuelType;
    private String colour;
     Vehicle(int id , String make, String model, int year, int price, int mileage, String fuelType, String colour){
         this.id = id;
         this.make = make;
         this.model = model;
         this.year = year;
         this.price = price;
         this.mileage = mileage;
         this.fuelType = fuelType;
         this.colour = colour;
     }

    public int getId() {
        return id;
    }

    public String getMake(){
         return make;
    }
    public String getModel(){
        return model;
    }
    public String getFuelType(){
        return fuelType;
    }

    public int getYear() {
         return year;
    }

    public int getPrice(){
            return price;
    }

    public int getMileage() {
         return mileage;
    }

    public String getColour() {
        return colour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMake(String make) {
         this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelType(String fuelType){
         this.fuelType = fuelType;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setMileage(int mileage){
         this.mileage = mileage;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
