/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Booking;

/**
 *
 * @author EHVN
 */
public class BookingList extends BaseList<Booking> {
    
    public BookingList() {
        super();
    }

    @Override
    public void add(Booking data) {
        super.add(new BookingNode(data));
    }

    @Override
    public void insert(int index, Booking data) {
        super.insert(index, new BookingNode(data));
    }
}
