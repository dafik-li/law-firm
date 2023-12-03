package com.solvd.lawfirm.entity.persons;

import com.solvd.lawfirm.interfaces.LevelInterface;
import java.util.Objects;
import java.util.function.Supplier;

public class SolicitorPerson extends AbstractPerson implements LevelInterface<SolicitorPerson> {
    private int level;
    private final Supplier<Integer> integerSupplier;

    public SolicitorPerson(char gender, String name, String surname, int age, int level) {
        super(gender, name, surname, age);
        this.level = level;
        this.integerSupplier = () -> this.getLevel(this);
    }
    @Override
    public int getLevel(SolicitorPerson solicitorPerson) {
        return level;
    }
    public void setLevel(int level) { this.level = level; }
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
    @Override
    public String toString() { return super.toString() + "\n" + "Level: " + this.integerSupplier.get(); }
}
