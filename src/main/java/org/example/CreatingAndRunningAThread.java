package org.example;

class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Custom thread run");
    }

    @Override
    public void start(){
        System.out.println("Custom thread start");
    }
}

public class CreatingAndRunningAThread {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("lambda runnable");

        new Thread(runnable).start();

        new Thread(() -> System.out.println("lambda directly from thread")).start();

        new CustomThread().start();
    }
}
