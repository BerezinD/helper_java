package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class FirstJob implements Runnable {
    private int i;
    private static FirstJob instance;

    private FirstJob(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        log.println("1: we implements Runnable interface and");
        log.println("1: this is an override method run() in new thread " + Thread.currentThread().getName() +
                " with i = " + i);
    }

    public static FirstJob getInstance() {
        if (instance == null) {
            instance = new FirstJob(122);
        }
        return instance;
    }
}
