package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null; // Initialize to null in case of an exception
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String[] headers = reader.readLine().split(Pattern.quote("|"));
            ArrayList<Vehicle> inventory = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carDetails = line.split(Pattern.quote("|"));
                Vehicle vehicle = makeVehicleClass(carDetails);
                inventory.add(vehicle);
            }
            dealership = new Dealership(headers[0], headers[1], headers[2]);
            for (Vehicle car : inventory){
                dealership.addVehicle(car);
            }
            System.out.println("New dealership\n" + dealership);
            System.out.println("");
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return dealership;
    }


    public Vehicle makeVehicleClass(String[] carDetails){
        int vin = Integer.parseInt(carDetails[0]);
        int year = Integer.parseInt(carDetails[1]);
        String make = carDetails[2];
        String model = carDetails[3];
        String vehicleType = carDetails[4];
        String color = carDetails[5];
        int odometer = Integer.parseInt(carDetails[6]);
        double price = Double.parseDouble(carDetails[7]);
        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }


    public void saveDealership(Dealership dealership){
        try {
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
            while (true){
                for (Vehicle vehicle : inventory){
                    writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                }
            }
            writer.close();
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
