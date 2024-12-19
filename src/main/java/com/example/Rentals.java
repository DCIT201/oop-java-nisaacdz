package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Represents a rental service for vehicles.
 * 
 * @param <T> the type of vehicle
 * @param <S> the type of supplier that supplies the vehicle
 */
public class Rentals<T extends Vehicle, S extends Supplier<T>> {

    /**
     * Represents a customer renting a vehicle.
     */
    public static class Customer {
        String name;
        String email;
        String phoneNumber;

        /**
         * Default constructor initializing the customer with default values.
         */
        public Customer() {
            this.name = "John Doe";
            this.email = "johndoe@domain.com";
            this.phoneNumber = "123456789";
        }

        /**
         * Constructs a customer with specified details.
         * 
         * @param name        the name of the customer
         * @param email       the email address of the customer
         * @param phoneNumber the phone number of the customer
         */
        public Customer(String name, String email, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    }

    protected static HashSet<Vehicle> availableVehicles = new HashSet<>();
    protected static HashMap<Vehicle, Customer> rentedVehicles = new HashMap<>();
    protected S supplier;

    /**
     * Constructs a rental service with a supplier and initializes vehicles.
     * 
     * @param supplier        the supplier of vehicles
     * @param initialVehicles the number of initial vehicles to add
     */
    public Rentals(S supplier, int initialVehicles) {
        this.supplier = supplier;
        for (int i = 0; i < initialVehicles; i++) {
            this.addNewVehicle();
        }
    }

    /**
     * Adds a new vehicle to the available vehicles set.
     */
    public void addNewVehicle() {
        availableVehicles.add(supplier.getNew());
    }

    /**
     * Rents a vehicle to a customer for a specified number of days.
     * 
     * @param customer the customer renting the vehicle
     * @param vehicle  the vehicle to be rented
     * @param days     the number of days for the rental
     * @return true if the vehicle was successfully rented, false otherwise
     */
    public boolean rent(Customer customer, Vehicle vehicle, int days) {
        if (isAvailableForRental(vehicle)) {
            availableVehicles.remove(vehicle);
            rentedVehicles.put(vehicle, customer);
            return true;
        }
        return false;
    }

    /**
     * Returns a rented vehicle to the available vehicles set.
     * 
     * @param vehicle the vehicle being returned
     * @return true if the vehicle was successfully returned, false otherwise
     */
    public boolean returnVehicle(Vehicle vehicle) {
        if (!isAvailableForRental(vehicle)) {
            rentedVehicles.remove(vehicle);
            availableVehicles.add(vehicle);
            return true;
        }
        return false;
    }

    /**
     * Checks if a vehicle is available for rental.
     * 
     * @param vehicle the vehicle to check
     * @return true if the vehicle is available for rental, false otherwise
     */
    public boolean isAvailableForRental(Vehicle vehicle) {
        return availableVehicles.contains(vehicle) && !rentedVehicles.containsKey(vehicle);
    }

    /**
     * Explores all vehicles, both available and rented.
     * 
     * @return a list of all vehicles
     */
    public ArrayList<Vehicle> exploreVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(availableVehicles);
        allVehicles.addAll(rentedVehicles.keySet());
        return allVehicles;
    }
}

/**
 * Interface representing a supplier of vehicles.
 * 
 * @param <T> the type of vehicle supplied
 */
interface Supplier<T extends Vehicle> {
    public Vehicle getNew();
}
