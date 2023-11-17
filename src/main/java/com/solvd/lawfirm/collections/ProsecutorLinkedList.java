package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.entity.persons.ProsecutorPerson;
import java.util.LinkedList;

public class ProsecutorLinkedList<T> {
    private Creator creator;

    public ProsecutorLinkedList() {
        this.creator = new Creator();
    }
    public LinkedList<ProsecutorPerson> createProsecutorPersonLinkedList() {
        LinkedList<ProsecutorPerson> prosecutorPersonLinkedList = new LinkedList<>();
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "johnny", "depp", 50, 3));
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "brad", "pitt", 50, 1));
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "leo", "dicaprio", 40, 2));
        return prosecutorPersonLinkedList;
    }
    public ProsecutorPerson findSProsecutor(int level) throws Exception {
        LinkedList<ProsecutorPerson> prosecutorList = createProsecutorPersonLinkedList();
        for (ProsecutorPerson prosecutor : prosecutorList) {
            if (prosecutor.getProsecutorLevel() == level) {
                return prosecutor;
            }
        }
        throw new Exception("Cannot find prosecutor");
    }
}
