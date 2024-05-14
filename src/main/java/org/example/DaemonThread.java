package org.example;

import jdk.swing.interop.SwingInterOpUtils;

public class DaemonThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("here");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("done");
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        System.out.println("main method finished");
        System.out.println(thread.isDaemon());
    }
}
