package org.example;

public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        timedWaitingState();
    }

    public static void newState(){
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
    }
    public static void runnableState(){
        Thread thread = new Thread(() -> {});
        thread.start();
        System.out.println(thread.getState());
    }

    public static void terminatedState(){
        Thread thread = new Thread(() -> {});
        thread.run();
        System.out.println(thread.getState());
    }

    public static void blockedState() throws InterruptedException {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                resource();
            }

            public static synchronized void resource(){
                while (true){
                    // mimic a process
                }
            }
        }

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();

        Thread.sleep(1000);


        System.out.println(t1.getState());
        System.out.println(t2.getState());

        System.exit(0);
    }

    public static void waitingState() throws InterruptedException {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static void timedWaitingState() throws InterruptedException {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }

        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());  // line 1
        Thread.sleep(5000);
        System.out.println(t1.getState());  // line 2
    }


}
