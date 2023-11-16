package com.solvd.lawfirm.entity.persons;

import com.solvd.lawfirm.interfaces.LevelProsecutorInterface;

import java.util.Objects;

public class ProsecutorPerson extends AbstractPerson implements LevelProsecutorInterface {
    private int level;

    public ProsecutorPerson(char gender, String name, String surname, int age, int level) {
        super(gender, name, surname, age);
        this.level = level;
    }
    @Override
    public int getProsecutorLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProsecutorPerson)) return false;
        if (!super.equals(o)) return false;
        ProsecutorPerson that = (ProsecutorPerson) o;
        return level == that.level;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), level);
    }
    @Override
    public String toString() {
        return super.toString() + "\n" + "Level: " + getProsecutorLevel();
    }
}
