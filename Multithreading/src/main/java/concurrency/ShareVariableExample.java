package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ShareVariableExample {
    static private double a = 10;
    static private double b;

    public static void main(String[] args) {
        Runnable readAWriteB = () -> {
            if (a == 10) {
                try {
                    Thread.sleep(1);
                    b = a/2;
                    log.println(Thread.currentThread().getName() + ": b = " + b);
                } catch (InterruptedException e) {
                    log.println(e);
                }
            }
        };
        Runnable changeA = () -> a = 12;
        Thread readAWriteBThread = new Thread(readAWriteB, "readAWriteBThread");
        Thread changeAThread = new Thread(changeA, "changeAThread");

        readAWriteBThread.start();
        changeAThread.start();
    }
}
