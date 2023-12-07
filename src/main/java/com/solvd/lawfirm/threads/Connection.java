package com.solvd.lawfirm.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Connection implements Runnable{
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(Connection.class);
    private int number;

    public Connection(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        LOGGER.info("Connection " + number + " started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        LOGGER.info("Connection " + number + " stopped");
        Execute.connectionPool.releaseConnection(this);
    }
}
