package com.solvd.lawfirm.entity.crimes;

import com.solvd.lawfirm.interfaces.CrimeInterface;

import java.util.Objects;

abstract public class AbstractCrime implements CrimeInterface {
    protected String typeOfCrime;
    protected int termOfPunishment;

    @Override
    public String getTypeOfCrime() { return typeOfCrime; }
    @Override
    public void setTypeOfCrime(String typeOfCrime) {
        this.typeOfCrime = typeOfCrime;
    }
    @Override
    public int getTermOfPunishment() { return termOfPunishment; }
    @Override
    public void setTermOfPunishment(int termOfPunishment) {
        this.termOfPunishment = termOfPunishment;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCrime)) return false;
        AbstractCrime that = (AbstractCrime) o;
        return getTermOfPunishment() == that.getTermOfPunishment() &&
                getTypeOfCrime().equals(that.getTypeOfCrime());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfCrime(), getTermOfPunishment());
    }
}
