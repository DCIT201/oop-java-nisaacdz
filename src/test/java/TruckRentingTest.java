import com.example.Rentals;
import com.example.Truck;

public class TruckRentingTest {
    public static void main(String[] args) {
        System.out.println("\n nHello Truck Renting Test!");
        // Supplier to generate new truck instances seamlessly
        Truck.TruckSupplier truckSupplier = new Truck.TruckSupplier();

        // This will create 12 trucks behind the scenes
        // These trucks can be viewed via the `exploreVehicles` method
        Rentals<Truck, Truck.TruckSupplier> truckRentals = new Rentals<>(truckSupplier, 12);

        var allTrucks = truckRentals.exploreVehicles();

        // Randomized calls to rent and returnVehicle to test the robustness of the code
        for (int i = 0; i < 18; i++) {
            int random = (int) (Math.random() * allTrucks.size() * 2) - allTrucks.size();
            if (random >= 0) {
                Truck truck = (Truck) allTrucks.get(random);
                System.out.println("Attempting to rent truck " + random);
                boolean rented = truckRentals.rent(new Rentals.Customer(), truck, 3);
                if (rented) {
                    System.out.println("Rented truck " + truck);
                } else {
                    System.out.println("Truck is not available for rent");
                }
            } else {
                Truck truck = (Truck) allTrucks.get(-random - 1);
                System.out.println("Attempting to return truck " + (-random - 1));
                boolean returned = truckRentals.returnVehicle(truck);
                if (returned) {
                    System.out.println("Returned truck " + truck);
                } else {
                    System.out.println("Truck has not been rented");
                }
            }
        }
    }
}
