package com.example;

public class CampusBike extends Vehicle {
    public static class BikeSupplier implements Supplier<CampusBike> {
        @Override
        public CampusBike getNew() {
            return new CampusBike();
        }
    }

    public CampusBike() {
        this.vehicleId = "CB001";
        this.model = "Campus Bike";
        this.baseRentalRate = 10.0;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "CampusBike{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
