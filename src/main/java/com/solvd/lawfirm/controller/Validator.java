package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.collections.EnumCrime;
//import com.solvd.lawfirm.entity.crimes.*;
import com.solvd.lawfirm.exceptions.CrimetypeException;
import com.solvd.lawfirm.exceptions.ProsecutorLevelException;
import com.solvd.lawfirm.exceptions.SolicitorLevelException;
import com.solvd.lawfirm.exceptions.WasArrestedBeforeException;

public class Validator {
    EnumCrime enumCrime;

    public void validateCrimeName(String crimeName) throws CrimetypeException {
        switch (crimeName) {
            case "homicide" : enumCrime = EnumCrime.HOMICIDE; break;
            case "robbery" : enumCrime = EnumCrime.ROBBERY; break;
            case "hooliganism" : enumCrime = EnumCrime.HOOLIGANISM; break;
            default : enumCrime = EnumCrime.DEFAULT; break;
        }
        crimeName.isEmpty();
        if (!crimeName.equals(enumCrime.getTypeOfCrime()))
        {
            throw new CrimetypeException("Entered an invalid crime name. You typed - " + crimeName);
        }
    }
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

