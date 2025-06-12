/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

/**
 *
 * @author EHVN
 */
public abstract class BaseList<T> {
    
    BaseNode<T> head;

    protected BaseList() {
        head = null;
    }

    public abstract void add(T data);

    protected void add(BaseNode<T> newNode)
    {
        if (head == null) {
            head = newNode;
        } else {
            BaseNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public abstract void insert(int index, T data);

    protected void insert(int index, BaseNode<T> newNode) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        BaseNode<T> current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        newNode.next = current.next;
        current.next = newNode;
    }
}