package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.collections.*;
import com.solvd.lawfirm.entity.crimes.EnumCrime;
import com.solvd.lawfirm.entity.result.Result;
//import com.solvd.lawfirm.entity.crimes.*;
import com.solvd.lawfirm.entity.persons.*;
import com.solvd.lawfirm.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Generator {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(Generator.class);
    private final Scanner scanner;
    private final Validator validator;
    private final SolicitorArrayList solicitorArrayList;
    private final ProsecutorLinkedList prosecutorLinkedList;
    private final SuspectedHashSet suspectedHashSet;
    //private final CrimeHashMap crimeHashMap;

    public Generator() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.solicitorArrayList = new SolicitorArrayList();
        this.prosecutorLinkedList = new ProsecutorLinkedList();
        this.suspectedHashSet = new SuspectedHashSet();
        //this.crimeHashMap = new CrimeHashMap();
    }
    private String getCrimeType() {
        LOGGER.info("\n" + "Type the crime (HOMICIDE, ROBBERY, HOOLIGANISM): ");
        String crimeName = scanner.nextLine();
        try {
            Function<EnumCrime, String> convert = String::valueOf;
            convert.apply(EnumCrime.valueOf(crimeName));
            //crimeName = EnumCrime.getTypeOfCrime(EnumCrime.valueOf(crimeName));
            validator.validateCrimeName(crimeName);
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.toString());
            return getCrimeType();
        }
        LOGGER.info("The type of crime is - " + crimeName);
        return crimeName;
        // return crimeHashMap.findCrime(crimeHashMap.createCrimeHashMap(), crimeName);
    }
    public int getLevelFromConsole(String type) {
        Consumer<String> enterLevel = x -> LOGGER.info("\n" + "Enter the " + x + " level (from 1 - to 3): ");
        enterLevel.accept(type);
        int levelFromConsole;
        String level = scanner.nextLine();
        try {
            levelFromConsole = Integer.parseInt(level);
            try {
                validator.validateLevelFromConsole(levelFromConsole);
                LOGGER.info(type + " level is - " + levelFromConsole);
            } catch (LevelFromConsoleException e) {
                LOGGER.error(e.toString());
                levelFromConsole = getLevelFromConsole(type);
            }
        } catch (NumberFormatException e) {
            LOGGER.error(e.toString());
            levelFromConsole = getLevelFromConsole(type);
        }
        return levelFromConsole;
    }
    private boolean isWasArrestedBefore() {
        LOGGER.info("\n" + "Is arrested before (1 - yes, 0 - no)?: ");
        int numberForArrested = scanner.nextInt();
        try {
            validator.validateArrestedBefore(numberForArrested);
            LOGGER.info("You typed - " + numberForArrested);
        } catch (WasArrestedBeforeException e) {
            LOGGER.error(e.toString());
        }
        if (numberForArrested == 1) {
            return true;
        }
        return false;
    }
    private static class Judge {
        public double exeCalc (SuspectedPerson suspectedPerson, String crimeType, SolicitorPerson
        solicitorPerson, ProsecutorPerson prosecutorPerson){
            double ratio;

            if (suspectedPerson.isWasArrestedBefore()) {
                ratio = 1.5;
            } else {
                ratio = 0.5;
            }
            return (ratio * EnumCrime.getTermOfPunishment(EnumCrime.valueOf(crimeType)))
                    / ((double) solicitorPerson.getLevel(solicitorPerson)
                    / prosecutorPerson.getLevel(prosecutorPerson));
        }
        public double exeCalc (SolicitorPerson solicitorPerson, String crimeType){
            return 1000 * solicitorPerson.getLevel(solicitorPerson)
                    * ((double) EnumCrime.getTermOfPunishment(EnumCrime.valueOf(crimeType)) / 5);
        }
    }
    public void getResult() throws Exception {
        String crimeType = getCrimeType();
        SolicitorPerson solicitor = solicitorArrayList.findSolicitor(getLevelFromConsole("solicitor"));
        ProsecutorPerson prosecutor = prosecutorLinkedList.findSProsecutor(getLevelFromConsole("prosecutor"));
        SuspectedPerson suspected = suspectedHashSet.findSuspected(isWasArrestedBefore());
        Judge calcResult = new Judge();
        double resultYears = calcResult.exeCalc(suspected, crimeType, solicitor, prosecutor);
        Result result = new Result(resultYears, suspected, solicitor, prosecutor);
        double sum = calcResult.exeCalc(solicitor, crimeType);
        LOGGER.info("\n" + result + "\n");
        LOGGER.info("\n" + "The payment is: " + sum);
        try (PrintWriter writer = new PrintWriter("judgement.txt")) {
            writer.println(result);
            writer.println("The payment is: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("File not exist or unwritable");
        }
        try (Scanner scanner = new Scanner(new File("judgement.txt"))) {
            while (scanner.hasNext()) {
                LOGGER.info(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
