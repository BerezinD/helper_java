package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class DeadlockExample {
    public static void main(String[] args) {
        final String resource1 = "Fork";
        final String resource2 = "Spoon";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                log.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    log.println("catch exception " + e.getMessage());
                }

                synchronized (resource2) {
                    log.println("Thread 1: locked resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                log.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    log.println("catch exception " + e.getMessage());
                }

                synchronized (resource1) {
                    log.println("Thread 2: locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
