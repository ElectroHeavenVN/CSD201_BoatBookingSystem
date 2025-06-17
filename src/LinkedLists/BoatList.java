/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Boat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author EHVN
 */
public class BoatList extends BaseList<Boat> {

    public BoatList() {
        super();
    }

    public boolean loadFromFile(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    String bcode = parts[0].trim();
                    String boatName = parts[1].trim();
                    int seat = Integer.parseInt(parts[2].trim());
                    int booked = Integer.parseInt(parts[3].trim());
                    String departPlace = parts[4].trim();
                    double rate = Double.parseDouble(parts[5].trim());
                    Boat boat = new Boat(bcode, boatName, seat, booked, departPlace, rate);
                    add(boat);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean addToHead(Boat data) {
        if (data == null) {
            return false;
        }
        BaseNode<Boat> current = head;
        while (current != null) {
            if (current.info.getBcode().equals(data.getBcode())) {
                return false;
            }
            current = current.next;
        }
        BoatNode newNode = new BoatNode(data);
        newNode.next = head;
        head = newNode;
        return true;
    }

    @Override
    public void add(Boat data) {
        super.add(new BoatNode(data));
    }

    @Override
    public void insert(int index, Boat data) {
        super.insert(index, new BoatNode(data));
    }

    public void display() {
        System.out.println("bcode\t|\tBoat_name\t|\t|Seat\t|\tBooked\t|\tDepart_place\t|\tRate\t|\tAvailable_seat");
        BaseNode<Boat> current = head;
        while (current != null) {
            System.out.println(current.info);
            current = current.next;
        }
    }

    public boolean saveToFile(String fileName) {
        try {
            File f = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            BaseNode<Boat> current = head;
            while (current != null) {
                Boat boat = current.info;
                String line = 
                    boat.getBcode() + " | " +
                    boat.getBoatName() + " | " +
                    boat.getSeat() + " | " +
                    boat.getBooked() + " | " +
                    boat.getDepartPlace() + " | " +
                    boat.getRate();
                bw.write(line);
                bw.newLine();
                current = current.next;
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
        return true;
    }

    public BoatNode searchByBcode(String bcode) {
        BaseNode<Boat> current = head;
        while (current != null) {
            if (current.info.getBcode().equals(bcode)) {
                return (BoatNode)current;
            }
            current = current.next;
        }
        return null; 
    }

    public boolean deleteByBcode(String bcode) {
        if (head == null) {
            return false;
        }
        if (head.info.getBcode().equals(bcode)) {
            head = head.next;
            return true;
        }
        BaseNode<Boat> current = head;
        while (current.next != null && !current.next.info.getBcode().equals(bcode)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public Boat[] sortByBcode() {
        Boat[] boats = toArray();
        Arrays.sort(boats, (b1, b2) -> b1.getBcode().compareTo(b2.getBcode()));
        return boats;
    }

    public boolean insertBefore(String bcode, Boat data) {
        if (head == null || data == null) {
            return false;
        }
        if (head.info.getBcode().equals(bcode)) {
            addToHead(data);
            return true;
        }
        BaseNode<Boat> current = head;
        while (current.next != null && !current.next.info.getBcode().equals(bcode)) {
            current = current.next;
        }
        if (current.next != null) {
            BoatNode newNode = new BoatNode(data);
            newNode.next = current.next;
            current.next = newNode;
            return true;
        }
        return false;
    }

    public boolean deleteBefore(String bcode) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next.info.getBcode().equals(bcode)) {
            head = head.next; 
            return true;
        }
        BaseNode<Boat> current = head;
        while (current.next != null && current.next.next != null && !current.next.next.info.getBcode().equals(bcode)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    private Boat[] toArray() {
        int size = 0;
        BaseNode<Boat> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        Boat[] array = new Boat[size];
        current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.info;
            current = current.next;
        }
        return array;
    }
}
