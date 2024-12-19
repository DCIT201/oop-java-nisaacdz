import com.example.Car;
import com.example.Rentals;

public class CarRentingTest {
    public static void main(String[] args) {
        System.out.println("\nHello world!");
        Car.CarSupplier carSupplier = new Car.CarSupplier();

        Rentals<Car, Car.CarSupplier> carRentals = new Rentals<>(carSupplier, 12);

        var allCars = carRentals.exploreVehicles();

        // Radomized calls to rent and returnVehicle to test the robustness of the code

        for (int i = 0; i < 18; i++) {
            int random = (int) (Math.random() * allCars.size() * 2) - allCars.size();
            if (random >= 0) {
                Car car = (Car) allCars.get(random);
                System.out.println("Attempting to rent car " + random);
                boolean rented = carRentals.rent(new Rentals.Customer(), car, 2);
                if (rented) {
                    System.out.println("Rented car " + car);
                } else {
                    System.out.println("Car is not available for rent");
                }
            } else {
                Car car = (Car) allCars.get(-random - 1);
                System.out.println("Attemping to return car " + (-random - 1));
                boolean returned = carRentals.returnVehicle(car);
                if (returned) {
                    System.out.println("Returned car " + car);
                } else {
                    System.out.println("Car has not been rented");
                }
            }
        }
    }
}
