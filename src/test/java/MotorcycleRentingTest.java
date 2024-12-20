import com.example.Motorcycle;
import com.example.Rentals;

public class MotorcycleRentingTest {
    public static void main(String[] args) {
        System.out.println("\nHello Motorcycle Renting Test!");
        // Supplier to generate new motorcycle instances seamlessly
        Motorcycle.MotorcycleSupplier motorcycleSupplier = new Motorcycle.MotorcycleSupplier();

        // This will create 12 motorcycles behind the scenes
        // These motorcycles can be viewed via the `exploreVehicles` method
        Rentals<Motorcycle, Motorcycle.MotorcycleSupplier> motorcycleRentals = new Rentals<>(motorcycleSupplier, 12);

        var allMotorcycles = motorcycleRentals.exploreVehicles();

        // Randomized calls to rent and returnVehicle to test the robustness of the code
        for (int i = 0; i < 18; i++) {
            int random = (int) (Math.random() * allMotorcycles.size() * 2) - allMotorcycles.size();
            if (random >= 0) {
                Motorcycle motorcycle = (Motorcycle) allMotorcycles.get(random);
                System.out.println("Attempting to rent motorcycle " + random);
                boolean rented = motorcycleRentals.rent(new Rentals.Customer(), motorcycle, 1);
                if (rented) {
                    System.out.println("Rented motorcycle " + motorcycle);
                } else {
                    System.out.println("Motorcycle is not available for rent");
                }
            } else {
                Motorcycle motorcycle = (Motorcycle) allMotorcycles.get(-random - 1);
                System.out.println("Attempting to return motorcycle " + (-random - 1));
                boolean returned = motorcycleRentals.returnVehicle(motorcycle);
                if (returned) {
                    System.out.println("Returned motorcycle " + motorcycle);
                } else {
                    System.out.println("Motorcycle has not been rented");
                }
            }
        }
    }
}
