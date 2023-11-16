package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.entity.persons.ProsecutorPerson;
import com.solvd.lawfirm.exceptions.ProsecutorLevelException;
import com.solvd.lawfirm.interfaces.LevelProsecutorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GiveBribe implements LevelProsecutorInterface {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(GiveBribe.class);
    private int bribe;
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getProsecutorLevel() {
        LOGGER.info("\n" + "Type a prosecutor level (from 1 - to 3): ");
        int levelProsecutor = scanner.nextInt();
        try {
            switch (levelProsecutor) {
                case 1 : bribe = 100;
                case 2 : bribe = 200;
                case 3 : bribe = 500;
                default : throw new ProsecutorLevelException("Invalid prosecutor level - " + levelProsecutor);
            }
        } catch (ProsecutorLevelException e) {
            e.printStackTrace();
            LOGGER.error("Invalid prosecutor level - " + levelProsecutor);
        } finally {
            LOGGER.info(levelProsecutor);
        }
        return levelProsecutor;
    }
    public void getBribe() {
        ProsecutorPerson prosecutorPerson = new ProsecutorPerson('m', "petya", "ivanov", 40, getProsecutorLevel());
        LOGGER.info("\n" + prosecutorPerson + "\n" + "Require a bribe: " + bribe);
        try (PrintWriter writer = new PrintWriter(new File("bribe.txt"))) {
            writer.println(prosecutorPerson);
            writer.println("Require a bribe: " + bribe);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("File not exist or unwritable");
        }
        try (Scanner scanner = new Scanner(new File("bribe.txt"))) {
            while (scanner.hasNext()) {
                LOGGER.info(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
