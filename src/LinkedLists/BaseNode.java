/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

/**
 *
 * @author EHVN
 */
public abstract class BaseNode<T> {
    BaseNode<T> next;
    T info;

    protected BaseNode() {
        this.next = null;
        this.info = null;
    }

    protected BaseNode(T info) {
        this.next = null;
        this.info = info;
    }

    protected BaseNode(T info, BaseNode<T> next) {
        this.info = info;
        this.next = next;
    }

    public BaseNode<T> getNext() {
        return next;
    }

    public void setNext(BaseNode<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}