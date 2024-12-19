package com.example;

public abstract class Vehicle {
    protected String vehicleId;
    protected String model;
    protected double baseRentalRate;
    protected boolean isAvailable;

    double calculateRentalCost(int days) {
        return baseRentalRate * days;
    }
    
    public boolean isAvailableForRental() {
        return isAvailable;
    }

    public static String generateRandomString(int length) {
        String characters = "012345678910ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (characters.length() * Math.random());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }
}