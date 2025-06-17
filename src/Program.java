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
            System.out.println("3. Display data");
            System.out.println("4. Save customer list to file");
            System.out.println("5. Search by ccode");
            System.out.println("6. Delete by ccode");
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
                        Customer newCustomer = Customer.readCustomer(sc);
                        if (customerList.searchByCcode(newCustomer.getcCode()) != null) {
                            System.out.println("Customer with this code already exists.");
                            break;
                        }
                        customerList.add(newCustomer);
                        System.out.println("Customer added to the end successfully.");
                        break;
                    case 3:
                        customerList.display();
                        break;
                    case 4:
                        System.out.print("Enter file path to save customer data: ");
                        String saveFilePath = sc.nextLine();
                        if (customerList.saveToFile(saveFilePath)) {
                            System.out.println("Customer data saved successfully.");
                        } else {
                            System.out.println("Failed to save customer data.");
                        }
                        break;
                    case 5:
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
                    case 6:
                        System.out.print("Enter customer code to delete: ");
                        String deleteCCode = sc.nextLine();
                        if (customerList.deleteByCcode(deleteCCode)) {
                            System.out.println("Customer deleted successfully.");
                        } else {
                            System.out.println("Customer not found or deletion failed.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 0-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
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