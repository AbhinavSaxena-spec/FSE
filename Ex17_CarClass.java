// Exercise 17: Class and Object Creation
public class Ex17_CarClass {

    // --- Car class definition ---
    static class Car {
        String make;
        String model;
        int    year;

        Car(String make, String model, int year) {
            this.make  = make;
            this.model = model;
            this.year  = year;
        }

        void displayDetails() {
            System.out.println(year + " " + make + " " + model);
        }
    }

    // --- Main method ---
    public static void main(String[] args) {
        Car c1 = new Car("Toyota",  "Corolla", 2020);
        Car c2 = new Car("Honda",   "Civic",   2022);
        Car c3 = new Car("Tesla",   "Model 3", 2023);

        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();
    }
}
