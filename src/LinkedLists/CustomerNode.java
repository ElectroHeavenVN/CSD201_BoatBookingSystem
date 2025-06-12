/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Customer;

/**
 *
 * @author EHVN
 */
public class CustomerNode extends BaseNode<Customer> {

    public CustomerNode() {
        super();
    }

    public CustomerNode(Customer customer) {
        super(customer);
    }

    public CustomerNode(Customer customer, CustomerNode next) {
        super(customer, next);
    }

    @Override
    public Customer getInfo() {
        return super.getInfo();
    }
    
    @Override
    public void setInfo(Customer boat) {
        super.setInfo(boat);
    }
    
    @Override
    public CustomerNode getNext() {
        return (CustomerNode)super.getNext();
    }
    
    public void setNext(CustomerNode boat) {
        super.setNext(boat);
    }
}