/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nb
fs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public boolean loadFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String cCode = parts[0].trim();
                    String customerName = parts[1].trim();
                    String phone = parts[2].trim();
                    if (phone.matches("\\d+")) {
                        Customer customer = new Customer(cCode, customerName, phone);
                        add(customer);
                    }
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean saveToFile(String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            CustomerNode current = (CustomerNode) head;
            while (current != null) {
                Customer customer = current.getInfo();
                fw.write(String.format("%s | %s | %s\n", 
                    customer.getcCode(), 
                    customer.getCustomerName(), 
                    customer.getPhone()));
                current = current.getNext();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public CustomerNode searchByCcode(String cCode) {
        CustomerNode current = (CustomerNode) head;
        while (current != null) {
            if (current.getInfo().getcCode().equals(cCode)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean deleteByCcode(String cCode) {
        if (head == null) {
            return false;
        }

        if (((CustomerNode) head).getInfo().getcCode().equals(cCode)) {
            head = head.getNext();
            return true;
        }

        CustomerNode current = (CustomerNode) head;
        while (current.getNext() != null) {
            if (((CustomerNode) current.getNext()).getInfo().getcCode().equals(cCode)) {
                current.setNext(((CustomerNode) current.getNext()).getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Customer list is empty.");
            return;
        }
        CustomerNode current = (CustomerNode) head;
        System.out.println("Customer List:");
        System.out.println("Code | Name | Phone");
        System.out.println("-------------------");
        while (current != null) {
            Customer customer = current.getInfo();
            System.out.printf("%s | %s | %s\n", 
                customer.getcCode(), 
                customer.getCustomerName(), 
                customer.getPhone());
            current = current.getNext();
        }
    }

    public Customer[] sortByCcode() {
        int size = size();
        Customer[] customers = new Customer[size];
        CustomerNode current = (CustomerNode) head;
        for (int i = 0; i < size; i++) {
            customers[i] = current.getInfo();
            current = current.getNext();
        }
        // Bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (customers[j].getcCode().compareTo(customers[j + 1].getcCode()) > 0) {
                    Customer temp = customers[j];
                    customers[j] = customers[j + 1];
                    customers[j + 1] = temp;
                }
            }
        }
        return customers;
    }

    public boolean insertBefore(String cCode, Customer data) {
        if (head == null) {
            return false;
        }
        if (((CustomerNode) head).getInfo().getcCode().equals(cCode)) {
            head = new CustomerNode(data, (CustomerNode) head);
            return true;
        }
        CustomerNode current = (CustomerNode) head;
        while (current.getNext() != null) {
            if (((CustomerNode) current.getNext()).getInfo().getcCode().equals(cCode)) {
                current.setNext(new CustomerNode(data, (CustomerNode) current.getNext()));
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteBefore(String cCode) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        if (((CustomerNode) head.getNext()).getInfo().getcCode().equals(cCode)) {
            head = head.getNext();
            return true;
        }
        CustomerNode current = (CustomerNode) head;
        while (current.getNext() != null && current.getNext().getNext() != null) {
            if (((CustomerNode) current.getNext().getNext()).getInfo().getcCode().equals(cCode)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        int count = 0;
        CustomerNode current = (CustomerNode) head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}