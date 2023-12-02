package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.entity.crimes.EnumCrime;
//import com.solvd.lawfirm.entity.crimes.*;
import com.solvd.lawfirm.exceptions.CrimetypeException;
import com.solvd.lawfirm.exceptions.ProsecutorLevelException;
import com.solvd.lawfirm.exceptions.SolicitorLevelException;
import com.solvd.lawfirm.exceptions.WasArrestedBeforeException;

public class Validator {

    public void validateCrimeName(String crimeName) throws CrimetypeException {
        if (crimeName.equals(EnumCrime.HOMICIDE.name())) {
            return;
        }
        if (crimeName.equals(EnumCrime.ROBBERY.name())) {
            return;
        }if (crimeName.equals(EnumCrime.HOOLIGANISM.name())) {
            return;
        }
            throw new CrimetypeException("Entered an invalid crime name. You typed - " + crimeName);
    }
    /*public void validateCrimeName(String crimeType) throws CrimetypeException {
        switch (crimeType) {
            case "HOMICIDE": EnumCrime.getTypeOfCrime(EnumCrime.valueOf(crimeType))); break;
            case "ROBBERY": EnumCrime.getTypeOfCrime(EnumCrime.ROBBERY); break;
            case "HOOLIGANISM": EnumCrime.getTypeOfCrime(EnumCrime.HOOLIGANISM); break;
        }
        throw new CrimetypeException("Entered an invalid crime name. You typed - " + crimeType);
    }
     */
    public void validateSolicitorLevel(int levelSolicitor) throws SolicitorLevelException {
        if (levelSolicitor > 3) {
            throw new SolicitorLevelException("Entered level is great than 3. You typed - " + levelSolicitor);
        }
        if (levelSolicitor < 1) {
            throw new SolicitorLevelException("Entered level is less than 1. You typed - " + levelSolicitor);
        }
    }
    public void validateProsecutorLevel(int levelProsecutor) throws ProsecutorLevelException {
        if (levelProsecutor > 3) {
            throw new ProsecutorLevelException("Entered level is great than 3. You typed - " + levelProsecutor);
        }
        if (levelProsecutor < 1) {
            throw new ProsecutorLevelException("Entered level is less than 1. You typed - " + levelProsecutor);
        }
    }
    public void validateArrestedBefore(int numberForArrested) throws WasArrestedBeforeException {
        if (numberForArrested == 1) {
        }
        if (numberForArrested == 0) {
        }
        else {
            throw new WasArrestedBeforeException("Please type 1 or 0");
        }
    }
}

