package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.interfaces.CrimeInterface;

public enum EnumCrime implements CrimeInterface {
    HOMICIDE ("homicide", 20),
    ROBBERY ("robbery", 10),
    HOOLIGANISM ("hooliganism", 5),
    DEFAULT ("default", 0);

    private String typeOfCrime;
    private int termOfPunishment;

    EnumCrime(String typeOfCrime, int termOfPunishment) {
        this.typeOfCrime = typeOfCrime;
        this.termOfPunishment = termOfPunishment;
    }

    public String toString() {
        return this.typeOfCrime;
    }

    @Override
    public String getTypeOfCrime() {
        return typeOfCrime;
    }
    @Override
    public void setTypeOfCrime(String typeOfCrime) {
        this.typeOfCrime = typeOfCrime;
    }
    @Override
    public int getTermOfPunishment() {
        return termOfPunishment;
    }
    @Override
    public void setTermOfPunishment(int termOfPunishment) {
        this.termOfPunishment = termOfPunishment;
    }
}


