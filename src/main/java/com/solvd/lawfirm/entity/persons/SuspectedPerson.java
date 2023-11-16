package com.solvd.lawfirm.entity.persons;

import java.util.Objects;

public class SuspectedPerson extends AbstractPerson {
    private boolean wasArrestedBefore;

    public SuspectedPerson(char gender, String name, String surname, int age, boolean wasArrestedBefore) {
        super(gender, name, surname, age);
        this.wasArrestedBefore = wasArrestedBefore;
    }

    public boolean isWasArrestedBefore() {
        return wasArrestedBefore;
    }
    public void setWasArrestedBefore(boolean wasArrestedBefore) {
        this.wasArrestedBefore = wasArrestedBefore;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuspectedPerson)) return false;
        if (!super.equals(o)) return false;
        SuspectedPerson that = (SuspectedPerson) o;
        return isWasArrestedBefore() == that.isWasArrestedBefore();
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWasArrestedBefore());
    }
    @Override
    public String toString() {
        return super.toString() + "\n" + "Was arrested before: " + isWasArrestedBefore();
    }
}
