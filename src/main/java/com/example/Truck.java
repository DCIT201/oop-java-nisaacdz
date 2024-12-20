package com.example;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a truck which is a type of vehicle.
 */
public class Truck extends Vehicle {

    /**
     * Supplies new instances of Truck.
     */
    public static class TruckSupplier implements Supplier<Truck> {

        /**
         * Creates and returns a new Truck instance with random properties.
         *
         * @return a new Truck instance.
         */
        @Override
        public Truck getNew() {
            Random random = new Random();
            TruckType truckType = TruckType.values()[random.nextInt(TruckType.values().length)];
            TruckBrand truckBrand = TruckBrand.values()[random.nextInt(TruckBrand.values().length)];
            Truck truck = new Truck();
            truck.truckType = truckType;
            truck.truckBrand = truckBrand;
            truck.vehicleId = Vehicle.generateRandomString(10);
            truck.model = truckBrand + " " + truckType;
            return truck;
        }
    }

    /**
     * Enum representing different types of trucks.
     */
    public static enum TruckType {
        PICKUP, TANKER, DUMP, FLATBED, BOX, CRANE, REFRIGERATED
    }

    /**
     * Enum representing different truck manufacturers.
     */
    public static enum TruckBrand {
        VOLVO, SCANIA, MERCEDES, FORD, FREIGHTLINER, KENWORTH, PETERBILT
    }

    /**
     * Gets the rate for a specific truck type.
     *
     * @param truckType the type of truck.
     * @return the rate for the truck type.
     */
    private static double rate(TruckType truckType) {
        return switch (truckType) {
            case PICKUP -> 150;
            case TANKER -> 300;
            case DUMP -> 200;
            case FLATBED -> 250;
            case BOX -> 180;
            case CRANE -> 350;
            case REFRIGERATED -> 400;
            default -> 1;
        };
    }

    /**
     * Gets the rate for a specific truck brand.
     *
     * @param truckBrand the manufacturer of the truck.
     * @return the rate for the truck brand.
     */
    private static double rate(TruckBrand truckBrand) {
        return switch (truckBrand) {
            case VOLVO -> 200;
            case SCANIA -> 220;
            case MERCEDES -> 250;
            case FORD -> 180;
            case FREIGHTLINER -> 240;
            case KENWORTH -> 260;
            case PETERBILT -> 270;
            default -> 1;
        };
    }

    private TruckType truckType;
    private TruckBrand truckBrand;

    /**
     * Calculates the rental cost for the truck based on the number of days.
     *
     * @param days the number of days the truck is rented.
     * @return the rental cost.
     */
    @Override
    public double calculateRentalCost(int days) {
        return rate(this.truckType) * rate(this.truckBrand) * days;
    }

    /**
     * Returns a string representation of the truck.
     *
     * @return a string representation of the truck.
     */
    @Override
    public String toString() {
        return "Truck{" + "vehicleId='" + vehicleId + '\'' + ", truckType=" + truckType + ", truckBrand=" + truckBrand + '}';
    }

    /**
     * Returns the hash code for the truck.
     *
     * @return the hash code for the truck.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, truckType, truckBrand);
    }

    /**
     * Compares this truck to another object for equality.
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
        Truck truck = (Truck) obj;
        return vehicleId.equals(truck.vehicleId) && truckType == truck.truckType && truckBrand == truck.truckBrand;
    }
}
