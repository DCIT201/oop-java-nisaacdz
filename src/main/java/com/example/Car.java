package com.example;

import java.util.Objects;
import java.util.Random;

public class Car extends Vehicle {
    public static class CarSupplier implements Supplier<Car> {
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

    public static enum CarType {
        SEDAN, SUV, TRUCK, COUPE, CONVERTIBLE, HATCHBACK, WAGON, VAN, JEEP, PICKUP
    }

    public static enum CarMake {
        TOYOTA, HONDA, FORD, CHEVROLET, NISSAN, DODGE, JEEP, SUBARU, BMW, MERCEDES
    }

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

    @Override
    public double calculateRentalCost(int days) {
        return rate(this.carType) * rate(this.carMake) * days;
    }

    @Override
    public String toString() {
        return "Car{" + "vehicleId='" + vehicleId + '\'' + ", carType=" + carType + ", carMake=" + carMake + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, carType, carMake);
    }

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
