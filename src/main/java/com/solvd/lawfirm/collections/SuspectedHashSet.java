package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.entity.persons.SuspectedPerson;

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
        /*suspectedList.forEach(
                (PersonInterface suspectedPerson) -> {
                    System.out.println("Suspected person: " + " " + suspectedPerson.getName() + " "
                            + suspectedPerson.getSurname());
                }
        );
         */
        createSuspectedPersons().stream()
                .peek(suspected -> System.out.println("Suspected person: "
                        + " " + suspected.getName()
                        + " " + suspected.getSurname()))
                .forEach(suspected -> suspected.getName().concat(suspected.getSurname()));
        return suspectedList.stream()
                .filter(suspected -> suspected.isWasArrestedBefore() == isWasArrestedBefore)
                .findAny().orElse(null);
    }
        /*for (SuspectedPerson suspected : suspectedList) {
            if (suspected.isWasArrestedBefore() == isWasArrestedBefore) {
                return suspected;
            }
        }
        throw new Exception("Cannot find suspected");
        */
    /*
    public List<String> searchPersonByAgeAndName() {
        List<AbstractPerson> abstractPersonList = new ArrayList<>();
        List<String> result = abstractPersonList.stream()
                .filter(abstractPerson -> abstractPerson.getName().contains("j"))
                .map(abstractPerson -> abstractPerson.getSurname())
                .filter(abstractPersonSurname -> abstractPersonSurname.startsWith("p"))
                .peek(abstractPersonSurname -> System.out.println(abstractPersonSurname))
                .collect(Collectors.toList());
        return result;
    }

    public boolean exists() {
        List<AbstractPerson> abstractPersonList = new ArrayList<>();
        boolean exists = abstractPersonList.stream()
                .filter(abstractPerson -> abstractPerson.getName().contains("j"))
                .map(abstractPerson -> abstractPerson.getSurname())
                .allMatch(surname -> surname.startsWith("d"));
        return true;
    }
    public Optional<AbstractPerson> optionalMethod() {
        List<AbstractPerson> abstractPersonList = new ArrayList<>();
        Optional<AbstractPerson> abstractPersonOptional = abstractPersonList.stream()
                .filter(abstractPerson -> abstractPerson.getSurname().contains("o"))
                .findFirst();
        if (abstractPersonOptional.isEmpty()) {
            abstractPersonOptional.get();
        }
        AbstractPerson abstractPerson = abstractPersonOptional
                .orElseThrow(() -> new NullPointerException("no person"));

        String result0 = doSmt(20)
                .orElseThrow(() -> new RuntimeException("null"));

        return abstractPersonOptional;
    }

    public static Optional<String> doSmt(int number) {
        String result = null;
        if (number > 20) {
            result = "Hallo!";
        }
        return Optional.ofNullable(result);
    }

     */
}


