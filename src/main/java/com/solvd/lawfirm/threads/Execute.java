package com.solvd.lawfirm.threads;

public class Execute {
    public volatile static ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.loadConnection();
        generator.loadConnectionByThreadPool();
        generator.loadConnectionByThread();
        generator.loadConnectionByThreadPoolUsingCompletableFuture();
        generator.loadConnectionByThreadUsingCompletableFuture();
    }
}
