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
        BaseNode<Booking> newNode = new BookingNode(data);
        if (head == null) {
            head = newNode;
        } else {
            BaseNode<Booking> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
