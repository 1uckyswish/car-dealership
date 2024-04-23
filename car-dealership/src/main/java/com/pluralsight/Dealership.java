package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;// Hippo City used cards
    private String address;// 111 old benny dr
    private String phone; // (803)-487-9900 ex
    private ArrayList<Vehicle> inventory;

    /**
     * This Class sets up a structure for creating dealership objects with
     * attributes
     *
     * @param name
     * @param phone
     * @param address
     */
    public Dealership(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.inventory = new ArrayList<>();
        // every time you create a new Dealership object using this constructor,
        // a new, empty ArrayList will be created and associated with that specific
        // Dealership object.
        // ensuring that each Dealership object has its own inventory list ready to be
        // populated with vehicle data.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Methods for dealership

    public ArrayList<Vehicle> getVehiclesByPrice() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByMake() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByYear() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByColor() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByMileage() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByType() {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        return searchResults;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
