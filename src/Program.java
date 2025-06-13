/*
 * Click nb
fs://nb
fs/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nb
fs://nb
fs/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Entities.*;
import LinkedLists.*;
import java.util.Scanner;

/**
 *
 * @author EHVN
 */
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoatList boatList = new BoatList();
        CustomerList customerList = new CustomerList();
        BookingList bookingList = new BookingList();

        while (true) {
            System.out.println("\n=================== MENU ===================");
            System.out.println("1. Boat List");
            System.out.println("2. Customer List");
            System.out.println("3. Booking List");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        boatMenu(sc, boatList);
                        break;
                    case 2:
                        customerMenu(sc, customerList, bookingList);
                        break;
                    case 3:
                        bookingMenu(sc, boatList, customerList, bookingList);
                        break;
                    case 0:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose 0-3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void boatMenu(Scanner sc, BoatList boatList) {
        while (true) {
            System.out.println("\n--- BOAT LIST MENU ---");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to the head");
            System.out.println("3. Display data");
            System.out.println("4. Save boat list to file");
            System.out.println("5. Search by bcode");
            System.out.println("6. Delete by bcode");
            System.out.println("7. Sort by bcode");
            System.out.println("8. Add before the node having bcode = xCode");
            System.out.println("9. Delete the node before the node having bcode = xCode");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            try {
                int opt = Integer.parseInt(sc.nextLine());
                switch (opt) {
                    case 1:
                        System.out.print("Enter file path to load boat data: ");
                        String filePath = sc.nextLine();
                        if (boatList.loadFromFile(filePath)) {
                            System.out.println("Boat data loaded successfully.");
                        } else {
                            System.out.println("Failed to load boat data.");
                        }
                        break;
                    case 2:
                        Boat newBoat = Boat.read();
                        if (boatList.searchByBcode(newBoat.getBcode()) != null) {
                            System.out.println("Boat with this code already exists.");
                            break;
                        }
                        boatList.addToHead(newBoat);
                        break;
                    case 3:
                        boatList.display();
                        break;
                    case 4:
                        System.out.print("Enter file path to save boat data: ");
                        String saveFilePath = sc.nextLine();
                        if (boatList.saveToFile(saveFilePath)) {
                            System.out.println("Boat data saved successfully.");
                        } else {
                            System.out.println("Failed to save boat data.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter boat code to search: ");
                        String searchBCode = sc.nextLine();
                        BoatNode foundBoat = boatList.searchByBcode(searchBCode);
                        if (foundBoat != null) {
                            System.out.println("Boat found:");
                            System.out.println(foundBoat.getInfo());
                        } else {
                            System.out.println("Boat not found.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter boat code to delete: ");
                        String deleteBCode = sc.nextLine();
                        if (boatList.deleteByBcode(deleteBCode)) {
                            System.out.println("Boat deleted successfully.");
                        } else {
                            System.out.println("Boat not found or deletion failed.");
                        }
                        break;
                    case 7:
                        Boat[] sortedBoats = boatList.sortByBcode();
                        System.out.println("Sorted boats by bcode:");
                        for (Boat boat : sortedBoats) {
                            System.out.println(boat);
                        }
                        break;
                    case 8:
                        System.out.print("Enter bcode to add before: ");
                        String xCode = sc.nextLine();
                        Boat newBoatToAdd = Boat.read();
                        if (boatList.insertBefore(xCode, newBoatToAdd)) {
                            System.out.println("Boat added successfully before " + xCode);
                        } else {
                            System.out.println("Failed to add boat before " + xCode);
                        }
                        break;
                    case 9:
                        System.out.print("Enter bcode to delete before: ");
                        String deleteBeforeBCode = sc.nextLine();
                        if (boatList.deleteBefore(deleteBeforeBCode)) {
                            System.out.println("Boat before " + deleteBeforeBCode + " deleted successfully.");
                        } else {
                            System.out.println("Failed to delete boat before " + deleteBeforeBCode);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 0-9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void customerMenu(Scanner sc, CustomerList customerList, BookingList bookingList) {
        while (true) {
            System.out.println("\n--- CUSTOMER LIST MENU ---");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Input & add to the head");
            System.out.println("4. Display data");
            System.out.println("5. Save customer list to file");
            System.out.println("6. Search by ccode");
            System.out.println("7. Delete by ccode");
            System.out.println("8. Sort by ccode");
            System.out.println("9. Add before the node having ccode = xCode");
            System.out.println("10. Delete the node before the node having ccode = xCode");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            try {
                int opt = Integer.parseInt(sc.nextLine());
                switch (opt) {
                    case 1:
                        System.out.print("Enter file path to load customer data (format: ccode | name | phone): ");
                        String filePath = sc.nextLine();
                        if (customerList.loadFromFile(filePath)) {
                            System.out.println("Customer data loaded successfully.");
                        } else {
                            System.out.println("Failed to load customer data. Ensure file exists and follows format.");
                        }
                        break;
                    case 2:
                        Customer newCustomer = readCustomer(sc);
                        if (customerList.searchByCcode(newCustomer.getcCode()) != null) {
                            System.out.println("Customer with this code already exists.");
                            break;
                        }
                        customerList.add(newCustomer);
                        System.out.println("Customer added to the end successfully.");
                        break;
                    case 3:
                        Customer newHeadCustomer = readCustomer(sc);
                        if (customerList.searchByCcode(newHeadCustomer.getcCode()) != null) {
                            System.out.println("Customer with this code already exists.");
                            break;
                        }
                        customerList.addToHead(newHeadCustomer);
                        System.out.println("Customer added to the head successfully.");
                        break;
                    case 4:
                        customerList.display();
                        break;
                    case 5:
                        System.out.print("Enter file path to save customer data: ");
                        String saveFilePath = sc.nextLine();
                        if (customerList.saveToFile(saveFilePath)) {
                            System.out.println("Customer data saved successfully.");
                        } else {
                            System.out.println("Failed to save customer data.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter customer code to search: ");
                        String searchCCode = sc.nextLine();
                        CustomerNode foundCustomer = customerList.searchByCcode(searchCCode);
                        if (foundCustomer != null) {
                            System.out.println("Customer found:");
                            System.out.println(foundCustomer.getInfo());
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;
                    case 7:
                        System.out.print("Enter customer code to delete: ");
                        String deleteCCode = sc.nextLine();
                        // Placeholder: Requires BookingList.hasBookingsForCustomer
                        // if (bookingList.hasBookingsForCustomer(deleteCCode)) {
                        //     System.out.println("Cannot delete customer with active bookings.");
                        //     break;
                        // }
                        if (customerList.deleteByCcode(deleteCCode)) {
                            System.out.println("Customer deleted successfully.");
                        } else {
                            System.out.println("Customer not found or deletion failed.");
                        }
                        break;
                    case 8:
                        Customer[] sortedCustomers = customerList.sortByCcode();
                        if (sortedCustomers.length == 0) {
                            System.out.println("Customer list is empty.");
                            break;
                        }
                        System.out.println("Sorted customers by ccode:");
                        for (Customer customer : sortedCustomers) {
                            System.out.println(customer);
                        }
                        break;
                    case 9:
                        System.out.print("Enter ccode to add before: ");
                        String xCode = sc.nextLine();
                        Customer newCustomerToAdd = readCustomer(sc);
                        if (customerList.searchByCcode(newCustomerToAdd.getcCode()) != null) {
                            System.out.println("Customer with this code already exists.");
                            break;
                        }
                        if (customerList.insertBefore(xCode, newCustomerToAdd)) {
                            System.out.println("Customer added successfully before " + xCode);
                        } else {
                            System.out.println("Failed to add customer before " + xCode + ". Code not found.");
                        }
                        break;
                    case 10:
                        System.out.print("Enter ccode to delete before: ");
                        String deleteBeforeCCode = sc.nextLine();
                        if (customerList.deleteBefore(deleteBeforeCCode)) {
                            System.out.println("Customer before " + deleteBeforeCCode + " deleted successfully.");
                        } else {
                            System.out.println("Failed to delete customer before " + deleteBeforeCCode + ". Code not found or no previous customer.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 0-10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static Customer readCustomer(Scanner sc) {
        System.out.print("Enter customer code: ");
        String cCode = sc.nextLine();
        while (cCode.trim().isEmpty()) {
            System.out.print("Customer code cannot be empty. Enter again: ");
            cCode = sc.nextLine();
        }
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        while (customerName.trim().isEmpty()) {
            System.out.print("Customer name cannot be empty. Enter again: ");
            customerName = sc.nextLine();
        }
        System.out.print("Enter phone number (digits only): ");
        String phone = sc.nextLine();
        while (!phone.matches("\\d+")) {
            System.out.print("Invalid phone number. Enter digits only: ");
            phone = sc.nextLine();
        }
        return new Customer(cCode, customerName, phone);
    }

    private static void bookingMenu(Scanner sc, BoatList boatList, CustomerList customerList, BookingList bookingList) {
        while (true) {
            System.out.println("\n--- BOOKING LIST MENU ---");
            System.out.println("1. Input booking");
            System.out.println("2. Display booking with available seats");
            System.out.println("3. Sort booking by bcode + ccode");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            try {
                int opt = Integer.parseInt(sc.nextLine());
                switch (opt) {
                    case 1:
                        bookingList.inputData(boatList, customerList);
                        break;
                    case 2:
                        bookingList.displayData();
                        break;
                    case 3:
                        bookingList.sortByBcodeandCcode();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 0-3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}