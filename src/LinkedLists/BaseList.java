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
    
    public void traverse() {
        //TODO
    }

    public abstract void add(T data);
}
