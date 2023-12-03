package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.exceptions.*;
import java.util.function.Predicate;

public class Validator {

    public void validateCrimeName(String crimeName) {
        Predicate<String> isCrime = nameOfCrime -> true;
        isCrime.test(crimeName);
    }
    public void validateLevelFromConsole(int levelFromConsole) throws LevelFromConsoleException {
        if (levelFromConsole > 3) {
            throw new LevelFromConsoleException("Entered level is great than 3. You typed - " + levelFromConsole);
        }
        if (levelFromConsole < 1) {
            throw new LevelFromConsoleException("Entered level is less than 1. You typed - " + levelFromConsole);
        }
    }
    public void validateArrestedBefore(int numberForArrested) throws WasArrestedBeforeException {
        if (numberForArrested == 1) {
            return;
        }
        if (numberForArrested == 0) {
            return;
        }
            throw new WasArrestedBeforeException("Please type 1 or 0");
    }
}

