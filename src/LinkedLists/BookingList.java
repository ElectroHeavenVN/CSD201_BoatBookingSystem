/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Boat;
import Entities.Booking;
import Entities.Customer;
import java.util.Scanner;

/**
 *
 * @author EHVN
 */
public class BookingList extends BaseList<Booking> {
    
    public BookingList() {
        super();
    }

    @Override
    public void insert(int index, Booking data) {
        super.insert(index, new BookingNode(data));
    }

    @Override
    public void add(Booking data) {
        super.add(new BookingNode(data));
    }
    //3.1
     public void inputData(BoatList boadList, CustomerList customerList){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter boat code: ");
        String bcode =sc.nextLine().trim();
        System.out.println("Enter customer code: ");
        String ccode =sc.nextLine().trim();
        System.out.println("Enter number of seats to be booked: ");
        int bookedSeat;
        try { bookedSeat = Integer.parseInt(sc.nextLine());
            if (bookedSeat <= 0) {
            System.out.println("Number of seats must be positive");
            return;
    }   
        } catch (NumberFormatException e) {
            System.out.println("Invalid number! Please enter an integer");
            return;
        }

        Boat boat = null;
        for (BoatNode curr = (BoatNode) boadList.head; curr != null; curr = curr.getNext()){
            if (curr.getInfo().getBcode().equalsIgnoreCase(bcode)){
                boat = curr.getInfo();
                break;
            }
        }

        Customer customer = null;
        for (CustomerNode curr = (CustomerNode) customerList.head; curr != null; curr = curr.getNext()){
            if (curr.getInfo().getcCode().equalsIgnoreCase(ccode)){
                customer = curr.getInfo();
                break;
            }
        }

        if(boat == null){
            System.out.println("Boat code not found");
            return;
        }

        if(customer == null){
            System.out.println("Customer code not found");
            return;
        }
        
        for (BookingNode curr = (BookingNode) head; curr != null; curr = curr.getNext()) {
            Booking b = curr.getInfo();
            if (b.getBcode().equals(bcode) && b.getcCode().equals(ccode)) {
                System.out.println("This booking already exists. Booking not accepted");
                return;
            }
        }

        if (boat.getBooked() >= boat.getSeat()){
            System.out.println("This boat is fully booked");
        }

        if (bookedSeat <= boat.getSeat() - boat.getBooked()){
            Booking newBooking =new Booking(bcode, ccode, bookedSeat);
            add(newBooking);
            boat.setBooked(boat.getBooked() + bookedSeat);
            System.out.println("Booking succesfully added");
        }else{
            System.out.println("Not enough seats available");
        }
    }

    //3.2
    public void displayData(){
        for (BookingNode curr = (BookingNode)head; curr != null; curr = curr.getNext()){
            Booking b = curr.getInfo();
            System.out.printf("Boat: %s, Customer: %s, Seats booked: %d%n", b.getBcode(), b.getcCode(), b.getSeat());
        }
    }

    //3.3
    public void sortByBcodeandCcode(){
        if (head == null || head.getNext() == null) return;
        for (BaseNode<Booking> i = head; i != null; i = i.getNext()){
            for (BaseNode<Booking> j = i.getNext(); j != null; j = j.getNext()){
                Booking bi = i.getInfo();
                Booking bj = j.getInfo();
                if (bi.getBcode().compareTo(bj.getBcode()) > 0 || (bi.getBcode().equals(bj.getBcode()) && bi.getcCode().compareTo(bj.getcCode()) > 0)){
                    Booking tmp = i.getInfo();
                    i.setInfo(j.getInfo());
                    j.setInfo(tmp);
                } 
            }
        }System.out.println("Booking list sorted by bcode and ccode.");
    }
}
