package concurrency.executors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Worker extends Thread {

    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            log.println(this.getName() + " and I do something...");
            sleep(2000);
        } catch (InterruptedException e) {
            log.println("error occur " + e.getMessage());
        }
        log.println(this.getName() + " and I am done!");
    }
}
