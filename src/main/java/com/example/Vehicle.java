package com.example;

public abstract class Vehicle {
    protected String vehicleId;
    protected String model;
    protected double baseRentalRate;
    protected boolean isAvailable;

    /**
     * Calculates the rental cost for the given number of days.
     *
     * @param days the number of days the vehicle is rented
     * @return the total rental cost
     */
    double calculateRentalCost(int days) {
        return baseRentalRate * days;
    }

    /**
     * Checks if the vehicle is available for rental.
     *
     * @return true if the vehicle is available for rental, false otherwise.
     */
    public boolean isAvailableForRental() {
        return isAvailable;
    }

    /**
     * Generates a random string of the specified length.
     *
     * @param length the length of the random string to generate
     * @return a random string of the specified length
     */
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