package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Rentals<T extends Vehicle, S extends Supplier<T>> {
    public static class Customer {
        String name;
        String email;
        String phoneNumber;
        
        public Customer() {
            this.name = "John Doe";
            this.email = "johndoe@domain.com";
            this.phoneNumber = "123456789";
        }
    
        public Customer(String name, String email, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    }
    
    protected static HashSet<Vehicle> availableVehicles = new HashSet<>();
    protected static HashMap<Vehicle, Customer> rentedVehicles = new HashMap<>();
    protected S supplier;

    public Rentals(S supplier, int initialVehicles) {
        this.supplier = supplier;
        for (int i = 0; i < initialVehicles; i++) {
            this.addNewVehicle();
        }
    }

    public void addNewVehicle() {
        availableVehicles.add(supplier.getNew());
    }

    public boolean rent(Customer customer, Vehicle vehicle, int days) {
        if (isAvailableForRental(vehicle)) {
            availableVehicles.remove(vehicle);
            rentedVehicles.put(vehicle, customer);
            return true;
        }
        return false;
    }

    public boolean returnVehicle(Vehicle vehicle) {
        if (!isAvailableForRental(vehicle)) {
            rentedVehicles.remove(vehicle);
            availableVehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean isAvailableForRental(Vehicle vehicle) {
        return availableVehicles.contains(vehicle) && !rentedVehicles.containsKey(vehicle);
    }

    public ArrayList<Vehicle> exploreVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(availableVehicles);
        allVehicles.addAll(rentedVehicles.keySet());
        return allVehicles;
    }
}

interface Supplier<T extends Vehicle> {
    public Vehicle getNew();
}