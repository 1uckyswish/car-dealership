package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    //Make a variable for to hold the new Instantiation of the object
    private Dealership dealership;

    // Calling this constructor starts the program my reading the CSV file and making a new Dealership
    UserInterface() {
        init();
    }

    /**
     * Instantiation of a new file reading is called with the values of the CSV applied to the class Dealership attribute
     */
    private void init() {
        //Call the method within the File Manager to get data from CSV
        DealershipFileManager fileManager = new DealershipFileManager();
        //Pass the values of the Dealership to the attribute at the top of the class
        this.dealership = fileManager.getDealership();
    }

    /**
     * Method hold the User Display screen for them to navigate the Dealership and its inventory
     */
    public void display() {
        Scanner scanner = new Scanner(System.in);
        //Create a boolean flag to check if user clicked the correct choice given
        boolean exit = false;

        //If not true continue
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
            //This will keep the program running unless the user types 0
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
                    processGetAllVehiclesRequest();
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

    /**
     * Method allows user to search through a price range they input using Scanner
     * @param scanner
     */
    private void processGetByPriceRequest(Scanner scanner) {
        System.out.println("\nPlease enter the price range you're interested in");
        //Pass the question and scanner into the method to validate the correct input data Type
        double minPrice = validateDoubleInput(scanner, "Please enter the minimum price: ");
        double maxPrice = validateDoubleInput(scanner, "Please enter the maximum price: ");
        scanner.nextLine(); // Consume newline buffer
        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByPrice(minPrice, maxPrice);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Price ====");
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available within the specified price range ===\n");
        }
    }

    /**
     * Method to process a request for getting vehicles by make and model using scanner
     * @param scanner
     */
    private void processGetByMakeModelRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
        //When it returns make it lowerCase for easier checking below
        System.out.print("Please specify the make: ");
        String makeName = validateStringInput(scanner, "Please enter the make name: ").toLowerCase();

        System.out.print("Please specify the model: ");
        String modelName = validateStringInput(scanner, "Please enter the model name: ").toLowerCase();

        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByMake(makeName, modelName);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            System.out.println("\n==== Vehicle Results By Make And Model ====");
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n=== Sorry, there are no vehicles available matching the specified make and model name ===\n");
        }
    }

    /**
     * Method to process a request for getting vehicles by Year using scanner
     * @param scanner
     */
    private void processGetByYearRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
        System.out.print("Please specify the year you are looking for: ");
        int yearChoice = validateIntInput(scanner, "Please enter the year: ");
        scanner.nextLine(); // Consume newline buffer
        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByYear(yearChoice);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Year ====");
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified year ====\n");
        }
    }

    /**
     * Method to process a request for getting vehicles by color using scanner
     * @param scanner
     */
    private void processGetByColorRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
        System.out.print("Please specify the color of the car you are looking for: ");
        //When it returns make it lowerCase for easier checking below
        String colorChoice = validateStringInput(scanner, "Please enter the car color: ").toLowerCase();
        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByColor(colorChoice);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Color ====");
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available in the specified color ====\n");
        }
    }


    /**
     * Method to process a request for getting vehicles by mileage using scanner
     * @param scanner
     */
    private void processGetByMileageRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
        System.out.print("Please specify the desired mileage for a vehicle: ");
        int mileageChoice = validateIntInput(scanner, "Please enter the desired mileage: ");
        scanner.nextLine(); // Consume newline buffer
        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByMileage(mileageChoice);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Mileage ====");
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available with the specified mileage ===\n");
        }
    }


    /**
     * Method to process a request for getting vehicles by vehicle type using scanner
     * @param scanner
     */
    private void processGetByVehicleTypeRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
        System.out.print("Please specify the type of vehicle you are looking for: ");
        //When it returns make it lowerCase for easier checking below
        String typeChoice = validateStringInput(scanner, "Please enter the type of vehicle: ").toLowerCase();

        //Pass the value the user submitted to the method of the dealership to do the checking
        ArrayList<Vehicle> searchResults = dealership.getVehiclesByType(typeChoice);

        //If the Arraylist values returned are true within the range, display them all
        if (!searchResults.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Type ====");
            //Passing the ArrayLost that hold the values pass it to a method that iterates through it and displays it
            displayVehicles(searchResults);
        } else {
            //if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified type ===\n");
        }
    }


    /**
     * Method to process a request for getting all vehicles
     */
    private void processGetAllVehiclesRequest() {
        //Call the dealership method to get all the Vehicles in the ArrayList
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        //Pass the ArrayList to the helper method
        displayVehicles(vehicles);
    }

    /**
     * Method to process adding a new vehicle to inventory using scanner
     * @param scanner
     */
    private void processAddVehicleRequest(Scanner scanner) {
        //Pass the question and scanner into the method to validate the correct input data Type
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

        //Pass all the variable to make a new Vehicle using its constructor
        Vehicle newVehicleMade = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        //Call the method within the dealership that handles adding a new Vehicle to the ArrayList
        dealership.addVehicle(newVehicleMade);
        // Save the updated dealership after adding the new vehicle
        DealershipFileManager fileManager = new DealershipFileManager();
        //Call the method that adds writes the current ArrayList everytime a new Vehicle is added to the CSV
        fileManager.saveDealership(dealership);
        //Show the new Vehicle they added
        System.out.println("==== New Vehicle Added ====");
        System.out.println(newVehicleMade);
    }

    /**
     * Method to process a request for removing a vehicle by its VIN #
     * @param scanner
     */
    private void processRemoveVehicleRequest(Scanner scanner) {
        //Call the helper method that gets all the vehicles from the ArrayList
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();
        //Pass the question and scanner into the method to validate the correct input data Type
        int vinChoice = validateIntInput(scanner, "Please enter the VIN of the vehicle to remove: ");
        scanner.nextLine(); // Consume newline character
        boolean found = false; //use a boolean flag to check if the VIN exist
        Vehicle temporaryVehicle = null; //Set Vehicle to null in case no VIN is found
        for (Vehicle vehicle : inventory) {
            //Loop through the Arraylist to find the Vin
            if (vehicle.getVin() == vinChoice) {
                //If found remove the Vehicle using the dealerships helper method
                temporaryVehicle = vehicle;
                dealership.removeVehicle(vehicle);
                //Update the boolean flag to true
                found = true;
                //Break out the loop when found
                break;
            }
        }
        //Use the boolean flag if no vehicle is found with that VIN
        if (!found) {
            System.out.println("\n==== Sorry, there are no vehicles available with the specified VIN ===\n");
        } else {
            //If Vin is found it will remove it
            //Display the user the Vehicle you removed
            System.out.println("\n==== Vehicle Removed ====");
            System.out.println(temporaryVehicle);
            // Save the updated dealership after removing the vehicle
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            // System.out.println("Remaining inventory:");
            // displayVehicles(dealership.getAllVehicles());
        }
    }

    /**
     * Method to process all Vehicles and display them
     * @param vehicles
     */
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("\n==== All Vehicle's In Inventory ====");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    /**
     * Method to process that the user input for Scanner is in fact Integer
     * @param scanner
     * @param prompt
     * @return
     */
    private int validateIntInput(Scanner scanner, String prompt) {
        //Set a starter value to use for returning
        int input;
        //Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            //Print out the question for user to respond to
            System.out.print(prompt);
            //If the scanner notices its asking for an Int, and it feeds it, then apply it to the variable
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                //Break out the loop when it matches
                break;
            } else {
                //If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        //return the user input
        return input;
    }

    /**
     * Method to process that the user input for Scanner is in fact String
     * @param scanner
     * @param prompt
     * @return
     */
    private String validateStringInput(Scanner scanner, String prompt) {
        //Set a starter value to use for returning
        String input;
        //Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            //Print out the question for user to respond to
            System.out.print(prompt);
            //If the scanner notices its asking for an String, and it feeds it, then apply it to the variable
            if (scanner.hasNextLine()) {
                //Break out the loop when it matches
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    break;
                }
            }
            //If user types something else then Int it will alert the user
            System.out.println("\n==== Sorry, that input is invalid. Please enter a valid non-empty string ===\n");
        }
        //return the user input
        return input;
    }

    /**
     * Method to process that the user input for Scanner is in fact Double
     * @param scanner
     * @param prompt
     * @return
     */
    private double validateDoubleInput(Scanner scanner, String prompt) {
        //Set a starter value to use for returning
        double input;
        //Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            //Print out the question for user to respond to
            System.out.print(prompt);
            //If the scanner notices its asking for a Double, and it feeds it, then apply it to the variable
            if (scanner.hasNextDouble()) {
                //Break out the loop when it matches
                input = scanner.nextDouble();
                break;
            } else {
                //If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        //return the user input
        return input;
    }

}
