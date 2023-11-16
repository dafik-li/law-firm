package com.solvd.lawfirm.entity.crimes;

public class HooliganismCrime extends AbstractCrime {
    protected String typeOfCrime = "hooliganism";
    protected int termOfPunishment = 5;

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

