package com.sander.deflect.support;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SanderThread {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void start(Runnable task) {
        pool.submit(task);
    }

    public static void shutdown() {
        pool.shutdown();
    }
}
