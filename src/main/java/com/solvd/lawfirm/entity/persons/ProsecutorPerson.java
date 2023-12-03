package com.solvd.lawfirm.entity.persons;

import com.solvd.lawfirm.interfaces.LevelInterface;
import java.util.Objects;
import java.util.function.Supplier;

public class ProsecutorPerson extends AbstractPerson implements LevelInterface<ProsecutorPerson> {
    private int level;
    private final Supplier<Integer> integerSupplier;

    public ProsecutorPerson(char gender, String name, String surname, int age, int level) {
        super(gender, name, surname, age);
        this.level = level;
        this.integerSupplier = () -> this.getLevel(this);
    }
    @Override
    public int getLevel(ProsecutorPerson prosecutorPerson) {
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
        return super.toString() + "\n" + "Level: " + integerSupplier.get();
    }
}
