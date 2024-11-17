package org.example;

public class Car {
    private int battery;
    private double fuelAmount;
    private double fuelCapacity;
    private double fuelConsumption;
    private double distanceTraveled = 0;

    public Car(int battery, double fuelAmount, double fuelCapacity, double fuelConsumption) {
        this.battery = battery;
        this.fuelAmount = fuelAmount;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public boolean refuel(double volume){
        if (volume <= 0)
            return false;
        double newVolume = volume + this.fuelAmount;
        this.fuelAmount = Math.min(newVolume, this.fuelCapacity);
        return true;
    }

    public boolean drive(double distance){
        if (distance <= 0 || distance > fuelAmount / fuelConsumption)
            return false;
        fuelAmount -= distance * fuelConsumption;
        distanceTraveled += distance;
        return true;
    }
    public boolean turnOn(){
        return this.battery > 10 && this.fuelAmount > 1;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        if (battery >= 0 && battery <= 100)
            this.battery = battery;
        else
            throw new IllegalArgumentException("Battery charge must be between 0 and 100.");
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
