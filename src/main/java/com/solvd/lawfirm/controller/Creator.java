package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.entity.persons.ProsecutorPerson;
import com.solvd.lawfirm.entity.persons.SolicitorPerson;
import com.solvd.lawfirm.entity.persons.SuspectedPerson;

public class Creator {

    public SuspectedPerson createSuspectedPerson (char gender, String name, String surname, int age, boolean wasArrestedBefore) {
        return new SuspectedPerson(gender, name, surname, age, wasArrestedBefore);
    }
    public SolicitorPerson createSolicitorPerson (char gender, String name, String surname, int age, int level) {
        return new SolicitorPerson(gender, name, surname, age, level);
    }
    public ProsecutorPerson createProsecutorPerson (char gender, String name, String surname, int age, int level) {
        return  new ProsecutorPerson(gender, name, surname, age, level);
    }
}
