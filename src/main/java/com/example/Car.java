package com.example;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a car which is a type of vehicle.
 */
public class Car extends Vehicle {

    /**
     * Supplies new instances of Car.
     */
    public static class CarSupplier implements Supplier<Car> {

        /**
         * Creates and returns a new Car instance with random properties.
         *
         * @return a new Car instance.
         */
        @Override
        public Car getNew() {
            Random random = new Random();
            CarType carType = CarType.values()[random.nextInt(CarType.values().length)];
            CarMake carMake = CarMake.values()[random.nextInt(CarMake.values().length)];
            Car car = new Car();
            car.carType = carType;
            car.carMake = carMake;
            car.vehicleId = Vehicle.generateRandomString(10);
            car.model = carMake + " " + carType;
            return car;
        }
    }

    /**
     * Enum representing different types of cars.
     */
    public static enum CarType {
        SEDAN, SUV, TRUCK, COUPE, CONVERTIBLE, HATCHBACK, WAGON, VAN, JEEP, PICKUP
    }

    /**
     * Enum representing different car manufacturers.
     */
    public static enum CarMake {
        TOYOTA, HONDA, FORD, CHEVROLET, NISSAN, DODGE, JEEP, SUBARU, BMW, MERCEDES
    }

    /**
     * Gets the rate for a specific car type.
     *
     * @param carType the type of car.
     * @return the rate for the car type.
     */
    private static double rate(CarType carType) {
        switch (carType) {
            case SEDAN:
                return 50;
            case SUV:
                return 100;
            case TRUCK:
                return 150;
            case COUPE:
                return 75;
            case CONVERTIBLE:
                return 125;
            case HATCHBACK:
                return 60;
            case WAGON:
                return 70;
            case VAN:
                return 200;
            case JEEP:
                return 120;
            case PICKUP:
                return 175;
            default:
                return 1;
        }
    }

    /**
     * Gets the rate for a specific car make.
     *
     * @param carMake the manufacturer of the car.
     * @return the rate for the car make.
     */
    private static double rate(CarMake carMake) {
        switch (carMake) {
            case TOYOTA:
                return 50;
            case HONDA:
                return 60;
            case FORD:
                return 70;
            case CHEVROLET:
                return 75;
            case NISSAN:
                return 65;
            case DODGE:
                return 80;
            case JEEP:
                return 120;
            case SUBARU:
                return 70;
            case BMW:
                return 100;
            case MERCEDES:
                return 110;
            default:
                return 1;
        }
    }

    private CarType carType;
    private CarMake carMake;

    /**
     * Calculates the rental cost for the car based on the number of days.
     *
     * @param days the number of days the car is rented.
     * @return the rental cost.
     */
    @Override
    public double calculateRentalCost(int days) {
        return rate(this.carType) * rate(this.carMake) * days;
    }

    /**
     * Returns a string representation of the car.
     *
     * @return a string representation of the car.
     */
    @Override
    public String toString() {
        return "Car{" + "vehicleId='" + vehicleId + '\'' + ", carType=" + carType + ", carMake=" + carMake + '}';
    }

    /**
     * Returns the hash code for the car.
     *
     * @return the hash code for the car.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, carType, carMake);
    }

    /**
     * Compares this car to another object for equality.
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
        Car car = (Car) obj;
        return vehicleId.equals(car.vehicleId) && carType == car.carType && carMake == car.carMake;
    }
}
