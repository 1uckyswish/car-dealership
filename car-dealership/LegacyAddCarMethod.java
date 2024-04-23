//public class LegacyAddCarMethod {
// // Method to process a request for adding a vehicle
// private void processAddVehicleRequest(Scanner scanner) {
//  System.out.print("Please enter the VIN # of the vehicle: ");
//  int vin;
//  while (!scanner.hasNextInt()) {
//   System.out.println("Sorry, that input is invalid. Please enter a valid
//           numeric value:");
//   System.out.print("Please enter the VIN # of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  vin = scanner.nextInt();
//
//
//  System.out.print("Please enter the year of the vehicle: ");
//  int year;
//  while (!scanner.hasNextInt()) {
//   System.out.println("Sorry, that input is invalid. Please enter a valid
//           numeric value:");
//   System.out.print("Please enter the year of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  year = scanner.nextInt();
//  scanner.nextLine();
//
//  System.out.print("Please enter the make of the vehicle: ");
//  String make;
//  while (!scanner.hasNextLine()) {
//   System.out.print("Sorry, that input is invalid. Please enter a valid
//           character value: ");
//   System.out.print("Please enter the make of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  make = scanner.nextLine().trim();
//
//
//  System.out.print("Please enter the model of the vehicle: ");
//  String model;
//  while (!scanner.hasNextLine()) {
//   System.out.print("Sorry, that input is invalid. Please enter a valid
//           character value: ");
//   System.out.print("Please enter the model of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  model = scanner.nextLine().trim();
//
//  String vehicleType;
//  System.out.print("Please enter the type of the vehicle (e.g., sedan, SUV):
//          ");
//  while (!scanner.hasNextLine()) {
//   System.out.print("Sorry, that input is invalid. Please enter a valid
//           character value: ");
//   System.out.print("Please enter the type of the vehicle (e.g., sedan, SUV):
//           ");
//           scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  vehicleType = scanner.nextLine().trim();
//
//  String color;
//  System.out.print("Please enter the color of the vehicle: ");
//  while (!scanner.hasNextLine()) {
//   System.out.print("Sorry, that input is invalid. Please enter a valid
//           character value: ");
//   System.out.print("Please enter the color of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  color = scanner.nextLine().trim();
//
//  int odometer;
//  System.out.print("Please enter the current mileage of the vehicle: ");
//  while (!scanner.hasNextInt()) {
//   System.out.println("Sorry, that input is invalid. Please enter a valid
//           numeric value:");
//   System.out.print("Please enter the current mileage of the vehicle: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  odometer = scanner.nextInt();
//
//  double price;
//  System.out.print("Please enter the price of the vehicle for sale: ");
//  while (!scanner.hasNextDouble()) {
//   System.out.println("Sorry, that input is invalid. Please enter a valid
//           numeric value:");
//   System.out.print("Please enter the price of the vehicle for sale: ");
//   scanner.next(); // Consume invalid input
//   //The loop continues until the user enters a valid numeric value.
//  }
//  price = scanner.nextDouble();
//
//  scanner.nextLine();
//  Vehicle newVehicleMade = new
//          Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
//  dealership.addVehicle(newVehicleMade);
//  // Save the updated dealership after adding the new vehicle
//  DealershipFileManager fileManager = new DealershipFileManager();
//  fileManager.saveDealership(dealership);
//  System.out.println("==== New Vehicle Added ====");
//  System.out.println(newVehicleMade);
//
// }
//}
