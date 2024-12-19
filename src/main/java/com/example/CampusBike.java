package com.example;

import java.util.Objects;

/**
 * Represents a Campus Bike which is a type of vehicle.
 */
public class CampusBike extends Vehicle {

    /**
     * Supplies new instances of CampusBike.
     */
    public static class BikeSupplier implements Supplier<CampusBike> {

        /**
         * Creates and returns a new CampusBike instance.
         *
         * @return a new CampusBike instance.
         */
        @Override
        public CampusBike getNew() {
            return new CampusBike();
        }
    }

    /**
     * Constructs a new CampusBike with default properties.
     */
    public CampusBike() {
        this.vehicleId = Vehicle.generateRandomString(9);
        this.model = "Campus Bike";
        this.baseRentalRate = 10.0;
        this.isAvailable = true;
    }

    /**
     * Returns a string representation of the CampusBike.
     *
     * @return a string representation of the CampusBike.
     */
    @Override
    public String toString() {
        return "CampusBike{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model +
                '}';
    }

    /**
     * Returns the hash code for the CampusBike.
     *
     * @return the hash code for the CampusBike.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, model, baseRentalRate, isAvailable);
    }

    /**
     * Compares this CampusBike to another object for equality.
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
        CampusBike that = (CampusBike) obj;
        return Double.compare(that.baseRentalRate, baseRentalRate) == 0 &&
                isAvailable == that.isAvailable &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(model, that.model);
    }
}
