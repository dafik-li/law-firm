package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.collections.SolicitorArrayList;
import com.solvd.lawfirm.entity.crimes.*;
import com.solvd.lawfirm.entity.persons.*;
import com.solvd.lawfirm.entity.result.Result;
import com.solvd.lawfirm.exceptions.CrimetypeException;
import com.solvd.lawfirm.exceptions.ProsecutorLevelException;
import com.solvd.lawfirm.exceptions.SolicitorLevelException;
import com.solvd.lawfirm.exceptions.WasArrestedBeforeException;
import com.solvd.lawfirm.interfaces.LevelProsecutorInterface;
import com.solvd.lawfirm.interfaces.LevelSolicitorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Generator implements LevelProsecutorInterface, LevelSolicitorInterface {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(Generator.class);
    private final static Object Result = null;
    private final static double sum = 0;
    private final Scanner scanner;
    private final Validator validator;
    private final CrimeFactory crimeFactory;
    private SolicitorArrayList solicitorArrayList;

    public Generator() {
        this.validator = new Validator();
        this.crimeFactory = new CrimeFactory();
        this.scanner = new Scanner(System.in);
        this.solicitorArrayList = new SolicitorArrayList();
    }
    public AbstractCrime getCrime() {
        LOGGER.info("\n" + "Type the crime (homicide, robbery, hooliganism): ");
        String crimeName = scanner.nextLine();
        try {
            validator.validateCrimeName(crimeName);
        } catch (CrimetypeException e) {
            LOGGER.error(e.toString());
            return getCrime();
        }
        LOGGER.info("The type of crime is - " + crimeName);
        return crimeFactory.create(crimeName);
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
    public boolean isWasArrestedBefore() {
        LOGGER.info("\n" + "Is arrested before (1 - yes, 0 - no)?: ");
        int numberForArrested = scanner.nextInt();
        try {
            validator.validateArrestedBefore(numberForArrested);
            LOGGER.info("Was arrested before - " + numberForArrested);
        } catch (WasArrestedBeforeException e) {
            LOGGER.error(e.toString());
            isWasArrestedBefore();
        }
        if (numberForArrested == 1) {
            return true;
        }
        return false;
    }
    public void getResult() {
        AbstractCrime crime = getCrime();
        SolicitorArrayList solicitorArrayList = new SolicitorArrayList();
        SolicitorPerson solicitorPerson = new SolicitorPerson('m', "dima", "pupkin", 30, getSolicitorLevel());
        ProsecutorPerson prosecutorPerson = new ProsecutorPerson('m', "petya", "ivanov", 40, getProsecutorLevel());
        SuspectedPerson suspectedPerson = new SuspectedPerson('f', "ira", "petrova", 25, isWasArrestedBefore());
        Judge calcResult = new Judge((com.solvd.lawfirm.entity.result.Result) Result, sum);
        double resultYears = calcResult.exeCalc(suspectedPerson, crime, solicitorPerson, prosecutorPerson);
        Result result = new Result(resultYears, suspectedPerson, solicitorPerson, prosecutorPerson);
        double sum = calcResult.exeCalc(solicitorPerson, crime);
        LOGGER.info("\n" + result + "\n");
        LOGGER.info("\n" + "The payment is: " + sum);
        try (PrintWriter writer = new PrintWriter(new File("judgement.txt"))) {
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
