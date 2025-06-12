/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedLists;

import Entities.Boat;

/**
 *
 * @author EHVN
 */
public class BoatNode extends BaseNode<Boat> {

    public BoatNode() {
        super();
    }

    public BoatNode(Boat boat) {
        super(boat);
    }

    public BoatNode(Boat boat, BoatNode next) {
        super(boat, next);
    }

    @Override
    public Boat getInfo() {
        return super.getInfo();
    }
    
    @Override
    public void setInfo(Boat boat) {
        super.setInfo(boat);
    }
    
    @Override
    public BoatNode getNext() {
        return (BoatNode)super.getNext();
    }
    
    public void setNext(BoatNode boat) {
        super.setNext(boat);
    }
}
