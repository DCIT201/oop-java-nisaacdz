import com.example.CampusBike;
import com.example.Rentals;

public class BikeRentingTest {
    public static void main(String[] args) {
        System.out.println("\nHello world!");
        // supplier to pass to the rentalService
        CampusBike.BikeSupplier bikeSupplier = new CampusBike.BikeSupplier();

        // This will create 12 bikes behind the scenes
        // These bikes can be viewed via the `exploreVehicles` method
        Rentals<CampusBike, CampusBike.BikeSupplier> bikeRentals = new Rentals<>(bikeSupplier, 12);

        var allCampusBikes = bikeRentals.exploreVehicles();

        // Radomized calls to rent and returnVehicle to test the robustness of the code

        for (int i = 0; i < 18; i++) {
            int random = (int) (Math.random() * allCampusBikes.size() * 2) - allCampusBikes.size();
            if (random >= 0) {
                CampusBike bike = (CampusBike) allCampusBikes.get(random);
                System.out.println("Attempting to rent bike " + random);
                boolean rented = bikeRentals.rent(new Rentals.Customer(), bike, 2);
                if (rented) {
                    System.out.println("Rented bike " + bike);
                } else {
                    System.out.println("bike is not available for rent");
                }
            } else {
                CampusBike bike = (CampusBike) allCampusBikes.get(-random - 1);
                System.out.println("Attemping to return bike " + (-random - 1));
                boolean returned = bikeRentals.returnVehicle(bike);
                if (returned) {
                    System.out.println("Returned bike " + bike);
                } else {
                    System.out.println("bike has not been rented");
                }
            }
        }
    }
}
