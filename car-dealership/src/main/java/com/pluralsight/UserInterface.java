package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    UserInterface(){
        init();
    }

    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display menu
            System.out.println("==== Dealership Menu ====");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by mileage");
            System.out.println("5. Get vehicles by vehicle type");
            System.out.println("6. Get all vehicles");
            System.out.println("7. Remove vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read user command
            String choice = scanner.nextLine();
            scanner.nextLine(); // Consume newline character

            // Process user command
            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByMileageRequest();
                    break;
                case "5":
                    processGetByVehicleTypeRequest();
                    break;
                case "6":
                    processGetAllVehiclesRequest();
                    break;
                case "7":
                    processRemoveVehicleRequest();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.print("\nInvalid choice. Please try again.\n");
                    display();
            }
        }

        scanner.close();
    }


    // Method to process a request for getting vehicles by price
    private void processGetByPriceRequest() {
        // Implementation
    }

    // Method to process a request for getting vehicles by make and model
    private void processGetByMakeModelRequest() {
        // Implementation
    }

    // Method to process a request for getting vehicles by year
    private void processGetByYearRequest() {
        // Implementation
    }

    // Method to process a request for getting vehicles by color
    private void processGetByColorRequest() {
        // Implementation
    }

    // Method to process a request for getting vehicles by mileage
    private void processGetByMileageRequest() {
        // Implementation
    }

    // Method to process a request for getting vehicles by vehicle type
    private void processGetByVehicleTypeRequest() {
        // Implementation
    }
    // Method to process a request for getting all vehicles
    private void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Method to process a request for adding a vehicle
    private void processAddVehicleRequest() {
        // Implementation
    }

    // Method to process a request for removing a vehicle
    private void processRemoveVehicleRequest() {
        // Implementation
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        System.out.println("==== List of Vehicles ====");
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

}
