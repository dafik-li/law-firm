package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.entity.persons.SuspectedPerson;
import com.solvd.lawfirm.interfaces.PersonInterface;

import java.util.HashSet;

public class SuspectedHashSet {
    private Creator creator;

    public SuspectedHashSet() {
        this.creator = new Creator();
    }

    public HashSet<SuspectedPerson> createSuspectedPersons() {
        HashSet<SuspectedPerson> suspectedPersonHashSet = new HashSet<>();
        suspectedPersonHashSet.add(creator.createSuspectedPerson
                ('f', "penelope", "cruz", 50, true));
        suspectedPersonHashSet.add(creator.createSuspectedPerson
                ('m', "matthew", "mcconaughey", 55, false));
        suspectedPersonHashSet.add(creator.createSuspectedPerson
                ('m', "jeremy", "clarkson", 65, true));
        return suspectedPersonHashSet;
    }
    public SuspectedPerson findSuspected (boolean isWasArrestedBefore) throws Exception {
        HashSet<SuspectedPerson> suspectedList = createSuspectedPersons();
        suspectedList.forEach(
                (PersonInterface suspectedPerson) -> {
                    System.out.println("Suspected person: " + " " + suspectedPerson.getName() + " "
                            + suspectedPerson.getSurname());
                }
        );
        for (SuspectedPerson suspected : suspectedList) {
            if (suspected.isWasArrestedBefore() == isWasArrestedBefore) {
                return suspected;
            }
        }
        throw new Exception("Cannot find suspected");
    }
}
