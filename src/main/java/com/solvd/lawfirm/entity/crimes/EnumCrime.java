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

    public static String getTypeOfCrime(EnumCrime crimeType) {
        switch (crimeType) {
            case HOMICIDE: return HOMICIDE.typeOfCrime;
            case ROBBERY: return ROBBERY.typeOfCrime;
            case HOOLIGANISM: return HOOLIGANISM.typeOfCrime;
            case DEFAULT: return DEFAULT.name();
        }
        return DEFAULT.name();
    }
    public static int getTermOfPunishment(EnumCrime crimeType) {
        switch (crimeType) {
            case HOMICIDE: return HOMICIDE.termOfPunishment;
            case ROBBERY: return ROBBERY.termOfPunishment;
            case HOOLIGANISM: return HOOLIGANISM.termOfPunishment;
            case DEFAULT: return DEFAULT.termOfPunishment;
        }
        return 0;
    }
}


