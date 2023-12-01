package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.collections.*;
import com.solvd.lawfirm.entity.result.Result;
//import com.solvd.lawfirm.entity.crimes.*;
import com.solvd.lawfirm.entity.persons.*;
import com.solvd.lawfirm.exceptions.CrimetypeException;
import com.solvd.lawfirm.exceptions.ProsecutorLevelException;
import com.solvd.lawfirm.exceptions.SolicitorLevelException;
import com.solvd.lawfirm.exceptions.WasArrestedBeforeException;
import com.solvd.lawfirm.interfaces.LevelProsecutorInterface;
import com.solvd.lawfirm.interfaces.LevelSolicitorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.io.*;
import java.util.Scanner;

public class Generator implements LevelProsecutorInterface, LevelSolicitorInterface {
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
    EnumCrime enumCrime;

    public Generator() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.solicitorArrayList = new SolicitorArrayList();
        this.prosecutorLinkedList = new ProsecutorLinkedList();
        this.suspectedHashSet = new SuspectedHashSet();
        //this.crimeHashMap = new CrimeHashMap();
    }
    private EnumCrime getCrime() throws Exception {
        LOGGER.info("\n" + "Type the crime (homicide, robbery, hooliganism): ");
        String crimeName = scanner.nextLine();
        try {
            validator.validateCrimeName(crimeName);
        } catch (CrimetypeException e) {
            LOGGER.error(e.toString());
            return getCrime();
        }
        LOGGER.info("The type of crime is - " + crimeName);
        return enumCrime; //(com.solvd.lawfirm.collections.EnumCrime) EnumCrime;
        // return crimeHashMap.findCrime(crimeHashMap.createCrimeHashMap(), crimeName);
    }
    @Override
    public int getSolicitorLevel() {
        LOGGER.info("\n" + "Enter the solicitor level (from 1 - to 3): ");
        int levelSolicitor;
        String level = scanner.nextLine();
        try {
            levelSolicitor = Integer.parseInt(level);
            try {
                validator.validateSolicitorLevel(levelSolicitor);
                LOGGER.info("Solicitor level is - " + levelSolicitor);
            } catch (SolicitorLevelException e) {
                LOGGER.error(e.toString());
                levelSolicitor = getSolicitorLevel();
            }
        } catch (NumberFormatException e) {
            LOGGER.error(e.toString());
            levelSolicitor = getSolicitorLevel();
        }
        return levelSolicitor;
    }
    @Override
    public int getProsecutorLevel() {
        LOGGER.info("\n" + "Enter the prosecutor level (from 1 - to 3): ");
        int levelProsecutor;
        String level = scanner.nextLine();
        try {
            levelProsecutor = Integer.parseInt(level);
            try {
                validator.validateProsecutorLevel(levelProsecutor);
                LOGGER.info("Prosecutor level is - " + levelProsecutor);
            } catch (ProsecutorLevelException e) {
                LOGGER.error(e.toString());
                levelProsecutor = getProsecutorLevel();
            }
        } catch (NumberFormatException e) {
            LOGGER.error(e.toString());
            levelProsecutor = getProsecutorLevel();
        }
        return levelProsecutor;
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
        public double exeCalc(SuspectedPerson suspectedPerson, EnumCrime enumCrime, SolicitorPerson solicitorPerson, ProsecutorPerson prosecutorPerson) {
            double ratio;

            if (suspectedPerson.isWasArrestedBefore()) {
                ratio = 1.5;
            } else {
                ratio = 0.5;
            }
            return (ratio * enumCrime.getTermOfPunishment()) / ((double) solicitorPerson.getSolicitorLevel() / prosecutorPerson.getProsecutorLevel());
        }
        public double exeCalc(SolicitorPerson solicitorPerson, EnumCrime enumCrime) {
            return 1000 * solicitorPerson.getSolicitorLevel() * ((double) enumCrime.getTermOfPunishment() / 5);
        }
    }
    public void getResult() throws Exception {
        EnumCrime crime = getCrime();
        SolicitorPerson solicitor = solicitorArrayList.findSolicitor(getSolicitorLevel());
        ProsecutorPerson prosecutor = prosecutorLinkedList.findSProsecutor(getProsecutorLevel());
        SuspectedPerson suspected = suspectedHashSet.findSuspected(isWasArrestedBefore());
        Judge calcResult = new Judge();
        double resultYears = calcResult.exeCalc(suspected, crime, solicitor, prosecutor);
        Result result = new Result(resultYears, suspected, solicitor, prosecutor);
        double sum = calcResult.exeCalc(solicitor, crime);
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
