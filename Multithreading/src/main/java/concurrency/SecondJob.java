package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class SecondJob extends Thread {

    @Override
    public void run() {
        log.println("2: we extends from Thread class and this is an override method run() in new thread " +
                 Thread.currentThread().getName());
    }
}
