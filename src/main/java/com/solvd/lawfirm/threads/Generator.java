package com.solvd.lawfirm.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Generator {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(Generator.class);
    public volatile static ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public void loadConnection() {
        Connection connection1 = connectionPool.getConnection();
        Thread threadConnection1 = new Thread(connection1);
        threadConnection1.start();
        Connection connection2 = connectionPool.getConnection();
        Thread threadConnection2 = new Thread(connection2);
        threadConnection2.start();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(connectionPool.getConnection());
        }
        executor.shutdown();
        waitBeforeFilling();
        LOGGER.info("Finished all threads and pool");
    }
    public void loadConnectionByThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++) {
            ThreadPool threadPool = new ThreadPool("" + i);
            executor.submit(threadPool);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        LOGGER.info("Finished all threads in the pool");
    }
    public void loadConnectionByThread() {
        for (int i = 0; i < 7; i++) {
            Connection connection = connectionPool.getConnection();
            Thread thread = new Thread(connection);
            thread.start();
        }
        waitBeforeFilling();
        LOGGER.info("Finished all threads");
    }
    public void waitBeforeFilling() {
        while (!(connectionPool.getNumberAvailableConnections() == connectionPool.getPoolNumbers())) {
        }
    }
    public void loadConnectionUsingCompletableFuture() {
        Connection connection1 = connectionPool.getConnection();
        CompletableFuture.runAsync(connection1);
        Connection connection2 = connectionPool.getConnection();
        CompletableFuture.runAsync(connection2);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(new Connection(i), executor);
        }
        executor.shutdown();
        waitBeforeFilling();
        while (!executor.isTerminated()) {
        }
        LOGGER.info("Completable Future - Finished all threads and pool");
    }

    public void loadConnectionByThreadPoolUsingCompletableFuture() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++) {
            CompletableFuture.runAsync(new Connection(i), executor);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        LOGGER.info("Completable Future - Finished all threads in the pool");
    }
    public void loadConnectionByThreadUsingCompletableFuture() {
        for (int i = 0; i < 7; i++) {
            Connection connection = connectionPool.getConnection();
            CompletableFuture.runAsync(connection);
        }
        waitBeforeFilling();
        LOGGER.info("Completable Future - Finished all threads");
    }
}

