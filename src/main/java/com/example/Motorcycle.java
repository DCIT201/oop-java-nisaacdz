package com.example;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a motorcycle which is a type of vehicle.
 */
public class Motorcycle extends Vehicle {

    /**
     * Supplies new instances of Motorcycle.
     */
    public static class MotorcycleSupplier implements Supplier<Motorcycle> {

        /**
         * Creates and returns a new Motorcycle instance with random properties.
         *
         * @return a new Motorcycle instance.
         */
        @Override
        public Motorcycle getNew() {
            Random random = new Random();
            MotorcycleType motorcycleType = MotorcycleType.values()[random.nextInt(MotorcycleType.values().length)];
            MotorcycleBrand motorcycleBrand = MotorcycleBrand.values()[random.nextInt(MotorcycleBrand.values().length)];
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.motorcycleType = motorcycleType;
            motorcycle.motorcycleBrand = motorcycleBrand;
            motorcycle.vehicleId = Vehicle.generateRandomString(10);
            motorcycle.model = motorcycleBrand + " " + motorcycleType;
            return motorcycle;
        }
    }

    /**
     * Enum representing different types of motorcycles.
     */
    public static enum MotorcycleType {
        SPORT, CRUISER, TOURING, STANDARD, DIRTBIKE, SCOOTER
    }

    /**
     * Enum representing different motorcycle manufacturers.
     */
    public static enum MotorcycleBrand {
        HONDA, YAMAHA, SUZUKI, KAWASAKI, BMW, HARLEY_DAVIDSON, DUCATI
    }

    /**
     * Gets the rate for a specific motorcycle type.
     *
     * @param motorcycleType the type of motorcycle.
     * @return the rate for the motorcycle type.
     */
    private static double rate(MotorcycleType motorcycleType) {
        return switch (motorcycleType) {
            case SPORT -> 80;
            case CRUISER -> 100;
            case TOURING -> 120;
            case STANDARD -> 70;
            case DIRTBIKE -> 60;
            case SCOOTER -> 50;
            default -> 1;
        };
    }

    /**
     * Gets the rate for a specific motorcycle brand.
     *
     * @param motorcycleBrand the manufacturer of the motorcycle.
     * @return the rate for the motorcycle brand.
     */
    private static double rate(MotorcycleBrand motorcycleBrand) {
        return switch (motorcycleBrand) {
            case HONDA -> 60;
            case YAMAHA -> 65;
            case SUZUKI -> 70;
            case KAWASAKI -> 80;
            case BMW -> 100;
            case HARLEY_DAVIDSON -> 120;
            case DUCATI -> 110;
            default -> 1;
        };
    }

    private MotorcycleType motorcycleType;
    private MotorcycleBrand motorcycleBrand;

    /**
     * Calculates the rental cost for the motorcycle based on the number of days.
     *
     * @param days the number of days the motorcycle is rented.
     * @return the rental cost.
     */
    @Override
    public double calculateRentalCost(int days) {
        return rate(this.motorcycleType) * rate(this.motorcycleBrand) * days;
    }

    /**
     * Returns a string representation of the motorcycle.
     *
     * @return a string representation of the motorcycle.
     */
    @Override
    public String toString() {
        return "Motorcycle{" + "vehicleId='" + vehicleId + '\'' + ", motorcycleType=" + motorcycleType + ", motorcycleBrand=" + motorcycleBrand + '}';
    }

    /**
     * Returns the hash code for the motorcycle.
     *
     * @return the hash code for the motorcycle.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, motorcycleType, motorcycleBrand);
    }

    /**
     * Compares this motorcycle to another object for equality.
     *
     * @param obj the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Motorcycle motorcycle = (Motorcycle) obj;
        return vehicleId.equals(motorcycle.vehicleId) && motorcycleType == motorcycle.motorcycleType && motorcycleBrand == motorcycle.motorcycleBrand;
    }
}
