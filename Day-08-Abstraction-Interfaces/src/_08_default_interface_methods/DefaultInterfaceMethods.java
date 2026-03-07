package _08_default_interface_methods;

interface Vehicle {
    // Abstract methods
    void start();
    void stop();

    // Default method (Java 8+)
    default void honk() {
        System.out.println("Beep beep!");
    }

    default void displayType() {
        System.out.println("This is a vehicle");
    }

    // Static method
    static  void service() {
        System.out.println("Vehicle needs regular servicing");
    }
}

interface ElectricVehicle extends Vehicle {
    void charge();

    default void displayBattery() {
        System.out.println("Battery status: 80%");
    }
}

class Car implements Vehicle {
    String brand;

    Car(String brand){
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println(brand + " car is starting");
    }

    @Override
    public void stop() {
        System.out.println(brand + " car is stopping");
    }

    // Override default method (optional)
    @Override
    public void honk() {
        System.out.println(brand + " car: HONK HONK!");
    }
}

class ElectricCar implements ElectricVehicle {
    String model;

    ElectricCar(String model) {
        this.model = model;
    }


    @Override
    public void start() {
        System.out.println(model + " electric car starting silently");
    }

    @Override
    public void stop() {
        System.out.println(model + " electric car stopping");
    }

    @Override
    public void charge() {
        System.out.println(model + " is charging...");
    }

    @Override
    public void displayType() {
        System.out.println("This is an electric vehicle");
    }
}

public class DefaultInterfaceMethods {
    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.start();
        car.honk();     // Uses overridden version
        car.displayType();  // Uses default version
        car.stop();

        System.out.println();

        ElectricCar tesla = new ElectricCar("Tesla Model 3");
        tesla.start();
        tesla.honk();   // Uses default version
        tesla.displayType();    // Uses overridden version
        tesla.charge();
        tesla.displayBattery();     // Uses default version
        tesla.stop();

        System.out.println();

        Vehicle.service();  // Call static method
    }
}
