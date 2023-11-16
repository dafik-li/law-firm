package com.solvd.lawfirm.entity.persons;

import com.solvd.lawfirm.interfaces.PersonInterface;

import java.util.Objects;

abstract public class AbstractPerson implements PersonInterface {
    protected char gender;
    protected String name;
    protected String surname;
    protected int age;

    public AbstractPerson(char gender, String name, String surname, int age) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPerson)) return false;
        AbstractPerson that = (AbstractPerson) o;
        return getGender() == that.getGender() &&
                getAge() == that.getAge() &&
                getName().equals(that.getName()) &&
                getSurname().equals(that.getSurname());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getGender(), getName(), getSurname(), getAge());
    }
    @Override
    public char getGender() {
        return gender;
    }
    @Override
    public void setGender(char gender) {
        this.gender = gender;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Gender: " + getGender() + "\n" + "Name: " + getName() + "\n" + "Surname: " + getSurname() + "\n" + "Age: " + getAge();
    }
}
