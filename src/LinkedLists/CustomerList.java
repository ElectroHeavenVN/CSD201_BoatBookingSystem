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
public class CustomerList extends BaseList<Customer> {
    
    public CustomerList() {
        super();
    }

    @Override
    public void add(Customer data) {
        BaseNode<Customer> newNode = new CustomerNode(data);
        if (head == null) {
            head = newNode;
        } else {
            BaseNode<Customer> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
