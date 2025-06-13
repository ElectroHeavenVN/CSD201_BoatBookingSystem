/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author EHVN
 */
public class Customer {
    private String cCode;
    private String customerName;
    private String phone;
@Override
public String toString() {
    return String.format("Code: %s, Name: %s, Phone: %s", cCode, customerName, phone);
}
    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String cCode, String customerName, String phone) {
        this.cCode = cCode;
        this.customerName = customerName;
        this.phone = phone;
    }
}
