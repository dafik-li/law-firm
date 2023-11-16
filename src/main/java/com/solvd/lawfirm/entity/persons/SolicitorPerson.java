package com.solvd.lawfirm.entity.persons;

import com.solvd.lawfirm.interfaces.LevelSolicitorInterface;

import java.util.Objects;

public class SolicitorPerson extends AbstractPerson implements LevelSolicitorInterface {
    private int level;

    public SolicitorPerson(char gender, String name, String surname, int age, int level) {
        super(gender, name, surname, age);
        this.level = level;
    }
    @Override
    public int getSolicitorLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    @Override
    public String toString() { return super.toString() + "\n" + "Level: " + getSolicitorLevel(); }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolicitorPerson)) return false;
        if (!super.equals(o)) return false;
        SolicitorPerson that = (SolicitorPerson) o;
        return level == that.level;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), level);
    }
}
