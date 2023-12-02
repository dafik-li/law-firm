package com.solvd.lawfirm.entity.crimes;

public enum EnumCrime {
    HOMICIDE("HOMICIDE", 20),
    ROBBERY("ROBBERY", 10),
    HOOLIGANISM("HOOLIGANISM", 5),
    DEFAULT("DEFAULT", 0);
    private final String typeOfCrime;
    private final int termOfPunishment;

    EnumCrime(String typeOfCrime, int termOfPunishment) {
        this.typeOfCrime = typeOfCrime;
        this.termOfPunishment = termOfPunishment;
    }
    public static int getTermOfPunishment(EnumCrime crimeType) {
        return crimeType.termOfPunishment;
    }
}


