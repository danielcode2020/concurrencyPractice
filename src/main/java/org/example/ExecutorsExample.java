package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newFixedThreadPool(5);

        ScheduledExecutorService service3 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(5);

        service.submit(() ->System.out.println("Hello"));


    }
}
