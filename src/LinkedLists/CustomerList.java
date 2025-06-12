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
        super.add(new CustomerNode(data));
    }

    @Override
    public void insert(int index, Customer data) {
        super.insert(index, new CustomerNode(data));
    }
}
