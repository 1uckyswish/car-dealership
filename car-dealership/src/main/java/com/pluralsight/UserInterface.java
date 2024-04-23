package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    UserInterface() {
        init();
    }

    private void init() {
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
                    break;
            }
        }

        // Close the scanner properly
        scanner.close();
    }

    // Method to process a request for getting vehicles by price
    private void processGetByPriceRequest(Scanner scanner) {
        System.out.println("\nPlease enter the price range you're interested in");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        double minPrice = validateDoubleInput(scanner, "Please enter the minimum price: ");
        double maxPrice = validateDoubleInput(scanner, "Please enter the maximum price: ");

        scanner.nextLine(); // Consume newline character

        boolean found = false;
        System.out.println("\n==== Vehicle Results By Price ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nSorry, there are no vehicles available within the specified price range.\n");
        }
    }

    // Method to process a request for getting vehicles by make and model
    private void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Please specify the make or model you are looking for: ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        String makeName = validateStringInput(scanner, "Please enter the make name: ").toLowerCase();

        String modelName = validateStringInput(scanner, "Please enter the model name: ").toLowerCase();

        boolean found = false;
        System.out.println("\n==== Vehicle Results By Make Or Model ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().toLowerCase().contains(makeName)
                    || vehicle.getModel().toLowerCase().contains(modelName)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, there are no vehicles available matching the specified make or model name.");
        }
    }

    // Method to process a request for getting vehicles by year
    private void processGetByYearRequest(Scanner scanner) {
        System.out.println("Please specify the year you are looking for: ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        int yearChoice = validateIntInput(scanner, "Please enter the year: ");
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        System.out.println("\n==== Vehicle Results By Year ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() == yearChoice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, there are no vehicles available for the specified year.");
        }
    }

    // Method to process a request for getting vehicles by color
    private void processGetByColorRequest(Scanner scanner) {
        System.out.println("Please specify the color of the car you are looking for: ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Please enter the car color: ");
        String colorChoice = validateStringInput(scanner, "Please enter the car color: ").toLowerCase();

        boolean found = false;
        System.out.println("\n==== Vehicle Result By Color ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().toLowerCase().contains(colorChoice)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, there are no vehicles available in the specified color.");
        }
    }

    // Method to process a request for getting vehicles by mileage
    private void processGetByMileageRequest(Scanner scanner) {
        System.out.println("Please specify the desired mileage for a vehicle: ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        int mileageChoice = validateIntInput(scanner, "Please enter the desired mileage: ");

        scanner.nextLine(); // Consume newline character

        boolean found = false;
        System.out.println("\n==== Vehicle Results By Mileage ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() == mileageChoice) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, there are no vehicles available with the specified mileage.");
        }
    }

    // Method to process a request for getting vehicles by vehicle type
    private void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("Please specify the type of vehicle you are looking for: ");
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        System.out.print("Please enter the type of vehicle: ");
        String typeChoice = validateStringInput(scanner, "Please enter the type of vehicle: ").toLowerCase();
        boolean found = false;
        System.out.println("\n==== Vehicle Results By Type ====");
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().toLowerCase().contains(typeChoice)) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, there are no vehicles available for the specified year.");
        }
    }

    // Method to process a request for getting all vehicles
    private void processGetAllVehiclesRequest(Scanner scanner) {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Method to process a request for adding a vehicle
    // private void processAddVehicleRequest(Scanner scanner) {
    // System.out.print("Please enter the VIN # of the vehicle: ");
    // int vin;
    // while (!scanner.hasNextInt()) {
    // System.out.println("Sorry, that input is invalid. Please enter a valid
    // numeric value:");
    // System.out.print("Please enter the VIN # of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // vin = scanner.nextInt();
    //
    //
    // System.out.print("Please enter the year of the vehicle: ");
    // int year;
    // while (!scanner.hasNextInt()) {
    // System.out.println("Sorry, that input is invalid. Please enter a valid
    // numeric value:");
    // System.out.print("Please enter the year of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // year = scanner.nextInt();
    // scanner.nextLine();
    //
    // System.out.print("Please enter the make of the vehicle: ");
    // String make;
    // while (!scanner.hasNextLine()) {
    // System.out.print("Sorry, that input is invalid. Please enter a valid
    // character value: ");
    // System.out.print("Please enter the make of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // make = scanner.nextLine().trim();
    //
    //
    // System.out.print("Please enter the model of the vehicle: ");
    // String model;
    // while (!scanner.hasNextLine()) {
    // System.out.print("Sorry, that input is invalid. Please enter a valid
    // character value: ");
    // System.out.print("Please enter the model of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // model = scanner.nextLine().trim();
    //
    // String vehicleType;
    // System.out.print("Please enter the type of the vehicle (e.g., sedan, SUV):
    // ");
    // while (!scanner.hasNextLine()) {
    // System.out.print("Sorry, that input is invalid. Please enter a valid
    // character value: ");
    // System.out.print("Please enter the type of the vehicle (e.g., sedan, SUV):
    // ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // vehicleType = scanner.nextLine().trim();
    //
    // String color;
    // System.out.print("Please enter the color of the vehicle: ");
    // while (!scanner.hasNextLine()) {
    // System.out.print("Sorry, that input is invalid. Please enter a valid
    // character value: ");
    // System.out.print("Please enter the color of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // color = scanner.nextLine().trim();
    //
    // int odometer;
    // System.out.print("Please enter the current mileage of the vehicle: ");
    // while (!scanner.hasNextInt()) {
    // System.out.println("Sorry, that input is invalid. Please enter a valid
    // numeric value:");
    // System.out.print("Please enter the current mileage of the vehicle: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // odometer = scanner.nextInt();
    //
    // double price;
    // System.out.print("Please enter the price of the vehicle for sale: ");
    // while (!scanner.hasNextDouble()) {
    // System.out.println("Sorry, that input is invalid. Please enter a valid
    // numeric value:");
    // System.out.print("Please enter the price of the vehicle for sale: ");
    // scanner.next(); // Consume invalid input
    // //The loop continues until the user enters a valid numeric value.
    // }
    // price = scanner.nextDouble();
    //
    // scanner.nextLine();
    // Vehicle newVehicleMade = new
    // Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
    // dealership.addVehicle(newVehicleMade);
    // // Save the updated dealership after adding the new vehicle
    // DealershipFileManager fileManager = new DealershipFileManager();
    // fileManager.saveDealership(dealership);
    // System.out.println("==== New Vehicle Added ====");
    // System.out.println(newVehicleMade);
    //
    // }
    private void processAddVehicleRequest(Scanner scanner) {
        int vin = validateIntInput(scanner, "Please enter the VIN # of the vehicle: ");
        int year = validateIntInput(scanner, "Please enter the year of the vehicle: ");
        scanner.nextLine(); // Consume newline character
        String make = validateStringInput(scanner, "Please enter the make of the vehicle: ");
        String model = validateStringInput(scanner, "Please enter the model of the vehicle: ");
        String vehicleType = validateStringInput(scanner, "Please enter the type of the vehicle (e.g., sedan, SUV): ");
        String color = validateStringInput(scanner, "Please enter the color of the vehicle: ");
        int odometer = validateIntInput(scanner, "Please enter the current mileage of the vehicle: ");
        double price = validateDoubleInput(scanner, "Please enter the price of the vehicle for sale: ");

        scanner.nextLine(); // Consume newline character

        Vehicle newVehicleMade = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicleMade);
        // Save the updated dealership after adding the new vehicle
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
        System.out.println("==== New Vehicle Added ====");
        System.out.println(newVehicleMade);
    }

    // Method to process a request for removing a vehicle
    private void processRemoveVehicleRequest(Scanner scanner) {
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        int vinChoice = validateIntInput(scanner, "Please enter the VIN of the vehicle to remove: ");
        scanner.nextLine(); // Consume newline character
        boolean found = false;
        Vehicle temporaryVehicle = null;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinChoice) {
                temporaryVehicle = vehicle;
                dealership.removeVehicle(vehicle);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Sorry, there are no vehicles available with the specified VIN.");
        } else {
            System.out.println("\n==== Vehicle Removed ====");
            System.out.println(temporaryVehicle);
            // Save the updated dealership after removing the vehicle
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            // System.out.println("Remaining inventory:");
            // displayVehicles(dealership.getAllVehicles());
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("\n==== All Vehicle's In Inventory ====");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private int validateIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("Sorry, that input is invalid. Please enter a valid numeric value");
                scanner.next(); // Consume invalid input
            }
        }
        return input;
    }

    private String validateStringInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    break;
                }
            }
            System.out.println("Sorry, that input is invalid. Please enter a valid non-empty string");
        }
        return input;
    }

    private double validateDoubleInput(Scanner scanner, String prompt) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                break;
            } else {
                System.out.println("Sorry, that input is invalid. Please enter a valid numeric value");
                scanner.next(); // Consume invalid input
            }
        }
        return input;
    }

}
