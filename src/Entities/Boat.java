/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;
import java.util.Scanner;

/**
 *
 * @author EHVN
 */
public class Boat {

    private String bcode;
    private String boatName;
    private int seat;
    private int booked;
    private String departPlace;
    private double rate;

    public Boat(String bcode, String boatName, int seat, int booked, String departPlace, double rate) {
        this.bcode = bcode;
        this.boatName = boatName;
        this.seat = seat;
        this.booked = booked;
        this.departPlace = departPlace;
        this.rate = rate;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getAvailableSeats() {
        return seat - booked;
    }

    @Override 
    public String toString() {
        return bcode + "\t|\t" + boatName + "\t|\t" + seat + "\t|\t" + booked + "\t|\t" + departPlace + "\t|\t" + rate + "\t|\t" + getAvailableSeats();
    }

    public static Boat read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter boat code: ");
        String bCode = sc.nextLine();
        System.out.print("Enter boat name: ");
        String boatName = sc.nextLine();
        int seat;
        do { 
            System.out.print("Enter number of seats: ");
            try {
                seat = sc.nextInt();
                sc.nextLine();
                if (seat > 0) 
                    break;
                System.out.println("Number of seats must be greater than 0. Please try again.");
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        } while (true);
        int booked;
        do {
            try {
                System.out.print("Enter number of booked seats: ");
                booked = sc.nextInt();
                sc.nextLine();
                if (booked >= 0 && booked <= seat) 
                    break;
                System.out.println("Booked seats must be between 0 and " + seat + ". Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        } while (true);
        System.out.print("Enter departure place: ");
        String departPlace = sc.nextLine();
        double rating;
        do {
            try {
                System.out.print("Enter rating: ");
                rating = sc.nextDouble();
                sc.nextLine();
                if (rating >= 0) 
                    break;
                System.out.println("Rating must be non-negative. Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        } while (true);
        return new Boat(bCode, boatName, seat, booked, departPlace, rating);
    }
}
