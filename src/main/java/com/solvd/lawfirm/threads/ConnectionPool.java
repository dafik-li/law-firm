package com.solvd.lawfirm.threads;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionPool {
    //lazy-initialization - initialize object in getInstance
    //thread-safe - using volatile
    private volatile static ConnectionPool instance;
    private final List<Connection> connections = new CopyOnWriteArrayList<>();
    private final int poolNumbers;

    public ConnectionPool(int poolNumbers) {
        this.poolNumbers = poolNumbers;
        for (int i = 0; i < this.poolNumbers; i++) {
            connections.add(new Connection(i + 1));
        }
    }
    //lazy-initialization with thread-safe and high performance - using double checked block with synchronized
    public static ConnectionPool getInstance(int poolNumbers) {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionPool(poolNumbers);
                }
            }
        }
        return localInstance;
    }
    public Connection getConnection() {
        while (connections.size() == 0) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return connections.remove(connections.size() - 1);
    }
    public void releaseConnection(Connection connection) {
        if (connections.size() < this.poolNumbers) {
            connections.add(connection);
        }
        synchronized (this) {
            notify();
        }
    }
    public int getNumberAvailableConnections() {
        return connections.size();
    }
    public int getPoolNumbers() {
        return this.poolNumbers;
    }
}
