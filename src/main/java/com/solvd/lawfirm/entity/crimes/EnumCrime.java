package com.solvd.lawfirm.entity.crimes;

public enum EnumCrime {
    HOMICIDE,
    ROBBERY,
    HOOLIGANISM,
    DEFAULT;
    public static String getTypeOfCrime(EnumCrime crimeType) {
        switch (crimeType) {
            case HOMICIDE: return HOMICIDE.name();
            case ROBBERY: return ROBBERY.name();
            case HOOLIGANISM: return HOOLIGANISM.name();
            case DEFAULT: return DEFAULT.name();
        }
        return DEFAULT.name();
    }
    public static int getTermOfPunishment(EnumCrime crimeType) {
        switch (crimeType) {
            case HOMICIDE: return 20;
            case ROBBERY: return 10;
            case HOOLIGANISM: return 5;
            case DEFAULT: return 0;
        }
        return 0;
    }
}


