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
public class BookingNode extends BaseNode<Booking> {

    public BookingNode() {
        super();
    }

    public BookingNode(Booking boat) {
        super(boat);
    }

    public BookingNode(Booking boat, BookingNode next) {
        super(boat, next);
    }

    @Override
    public Booking getInfo() {
        return super.getInfo();
    }
    
    @Override
    public void setInfo(Booking boat) {
        super.setInfo(boat);
    }
    
    @Override
    public BookingNode getNext() {
        return (BookingNode)super.getNext();
    }
    
    public void setNext(BookingNode boat) {
        super.setNext(boat);
    }
}