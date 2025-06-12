/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Boat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author EHVN
 */
public class BoatList extends BaseList<Boat> {
    
    public BoatList() {
        super();
    }
    @Override
    public void add(Boat data) {
        BaseNode<Boat> newNode = new BoatNode(data);
        if (head == null) {
            head = newNode;
        } else {
            BaseNode<Boat> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
