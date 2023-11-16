package com.solvd.lawfirm.controller;

import com.solvd.lawfirm.entity.persons.SolicitorPerson;
import com.solvd.lawfirm.exceptions.SolicitorLevelException;
import com.solvd.lawfirm.interfaces.LevelSolicitorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class PaySalary implements LevelSolicitorInterface {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(PaySalary.class);
    private int salary;
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getSolicitorLevel(){
        LOGGER.info("\n" + "Type a solicitor level (from 1 - to 3): ");
        int levelSolicitor = scanner.nextInt();
        try {
            if (levelSolicitor == 1) {
                salary = 650;
            } else if (levelSolicitor == 2) {
                salary = 900;
            } else if (levelSolicitor == 3) {
                salary = 1200;
            } else {
                throw new SolicitorLevelException("Invalid solicitor level - " + levelSolicitor);
            }
        } catch (SolicitorLevelException e) {
            e.printStackTrace();
            LOGGER.error("Invalid solicitor level - " + levelSolicitor);
        } finally {
            LOGGER.info(levelSolicitor);
        }
        return levelSolicitor;
    }
    public void getSalary() {
        SolicitorPerson solicitorPerson = new SolicitorPerson('m', "dima", "pupkin", 30, getSolicitorLevel());
        LOGGER.info("\n" + solicitorPerson + "\n" + "Earns: " + salary);
        try (PrintWriter writer = new PrintWriter(new File("salary.txt"))) {
            writer.println(solicitorPerson);
            writer.println("Salary is: " + salary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("File not exist or unwritable");
        }
        try (Scanner scanner = new Scanner(new File("salary.txt"))) {
            while (scanner.hasNext()) {
                LOGGER.info(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
