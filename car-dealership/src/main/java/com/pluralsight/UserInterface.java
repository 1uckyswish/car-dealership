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
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by vehicle type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read user command
            String choice = scanner.nextLine();

            // Process user command
            switch (choice) {
                case "1":
                    processGetByPriceRequest(scanner);
                    break;
                case "2":
                    processGetByMakeModelRequest(scanner);
                    break;
                case "3":
                    processGetByYearRequest(scanner);
                    break;
                case "4":
                    processGetByColorRequest(scanner);
                    break;
                case "5":
                    processGetByMileageRequest(scanner);
                    break;
                case "6":
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case "7":
                    processGetAllVehiclesRequest(scanner);
                    break;
                case "8":
                    processAddVehicleRequest(scanner);
                    break;
                case "9":
                    processRemoveVehicleRequest(scanner);
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
    private void processGetByPriceRequest(Scanner scanner) {
        System.out.println("What price are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter minimum price: ");
        double minPrice;
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid numeric value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        minPrice = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double maxPrice;
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid numeric value: ");
            scanner.next(); // Consume invalid input
        }
        maxPrice = scanner.nextDouble();

        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found within the specified price range.");
        }
    }


    // Method to process a request for getting vehicles by make and model
    private void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("What Make or Model are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter Make Name: ");
        String makeName;
        while (!scanner.hasNextLine()) {
            System.out.print("Invalid input. Please enter a valid character value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        makeName = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter Model Name: ");
        String modelName;
        while (!scanner.hasNextLine()) {
            System.out.print("Invalid input. Please enter a valid character value: ");
            scanner.next(); // Consume invalid input
        }
        modelName = scanner.nextLine().trim().toLowerCase();


        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().toLowerCase().contains(makeName) || vehicle.getModel().toLowerCase().contains(modelName)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found within the specified Make or Model name.");
        }
    }

    // Method to process a request for getting vehicles by year
    private void processGetByYearRequest(Scanner scanner) {
        System.out.println("What year are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter Year: ");
        int yearChoice;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        yearChoice = scanner.nextInt();

        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() == yearChoice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found by the specified year.");
        }
    }

    // Method to process a request for getting vehicles by color
    private void processGetByColorRequest(Scanner scanner) {
        System.out.println("What Color car are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter Car Color: ");
        String colorChoice;
        while (!scanner.hasNextLine()) {
            System.out.print("Invalid input. Please enter a valid character value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        colorChoice = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().toLowerCase().contains(colorChoice)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with the specified color.");
        }
    }

    // Method to process a request for getting vehicles by mileage
    private void processGetByMileageRequest(Scanner scanner) {
        System.out.println("How much mileage in a car are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter Mileage: ");
        int mileageChoice;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        mileageChoice = scanner.nextInt();

        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() == mileageChoice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found by the specified mileage.");
        }
    }

    // Method to process a request for getting vehicles by vehicle type
    private void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("What type of vehicle are you looking for? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter vehicle type: ");
        String typeChoice;
        while (!scanner.hasNextLine()) {
            System.out.print("Invalid input. Please enter a valid character value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        typeChoice = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().toLowerCase().contains(typeChoice)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found by the specified year.");
        }
    }
    // Method to process a request for getting all vehicles
    private void processGetAllVehiclesRequest(Scanner scanner){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Method to process a request for adding a vehicle
    private void processAddVehicleRequest(Scanner scanner) {
        System.out.print("Please enter the Vehicle Vin number: ");
         int vin = scanner.nextInt();
        System.out.print("Please enter the Vehicle Year: ");
         int year = scanner.nextInt();
         scanner.nextLine();
        System.out.print("Please enter the Vehicle Make: ");
         String make = scanner.nextLine().trim();
        System.out.print("Please enter the Vehicle Model: ");
         String model  = scanner.nextLine().trim();
        System.out.print("Please enter the Vehicle Type: ");
         String vehicleType = scanner.nextLine().trim();
        System.out.print("Please enter the Vehicle Color: ");
         String color = scanner.nextLine().trim();
        System.out.print("Please enter the Vehicle Current Mileage: ");
         int odometer = scanner.nextInt();
        System.out.print("Please enter the Vehicle Price For Sale: ");
         double price = scanner.nextDouble();
        scanner.nextLine();
        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
    }

    // Method to process a request for removing a vehicle
    private void processRemoveVehicleRequest(Scanner scanner) {
        System.out.println("What is the VIN number of the vehicle to remove? ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Enter vehicle type: ");
        int vinChoice;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numerical value: ");
            scanner.next(); // Consume invalid input
            //The loop continues until the user enters a valid numeric value.
        }
        vinChoice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinChoice) {
                dealership.removeVehicle(vehicle);
                System.out.println(vehicle);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No vehicles found with the specified VIN.");
        } else {
            System.out.println("Remaining inventory:");
            displayVehicles(dealership.getAllVehicles());
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        System.out.println("==== List of Vehicles ====");
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

}
