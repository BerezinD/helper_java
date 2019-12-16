package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class PoolExample {
    public static void main(String[] args) {
        // create a POOL of 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new Worker("I'm a thread number " + i);
            executor.execute(worker);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
            // do nothing
        }
        log.println("Executor has finished all tasks");
    }
}
