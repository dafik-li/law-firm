package com.solvd.lawfirm.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class SingleThread extends Thread {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(ThreadPool.class);
    private final String command;

    public SingleThread(String command) {
        this.command = command;
    }
    @Override
    public void run() {
        LOGGER.info(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        LOGGER.info(Thread.currentThread().getName() + " End");
    }
    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return this.command;
    }
}

