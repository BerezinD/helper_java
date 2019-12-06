package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class CountingThread extends Thread {

    CountingThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            log.println("countdown... " + i);
        }
        log.println("Thread " + Thread.currentThread().getName() + " finish!");
    }
}
