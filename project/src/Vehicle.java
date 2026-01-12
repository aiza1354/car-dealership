public class Vehicle {
     String make;
     String model;
     int year;
     int price;
     int mileage;
     String fuelType;

     Vehicle(String make, String model, int year, int price, int mileage, String fuelType){
         this.make = make;
         this.model = model;
         this.year = year;
         this.price = price;
         this.mileage = mileage;
         this.fuelType = fuelType;
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


}
