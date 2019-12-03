package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class NewThreadsExample {

    public static void main(String[] args) {

        //create a thread using our class that implements runnable
        //1
        new Thread(FirstJob.getInstance()).start();
        //2
        new SecondJob().start();

        final String nameRunnable = "name of new thread with static runnable ";
        final String nameOfCurrentThread = "; and current name of thread";
        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                log.println("3: " + nameRunnable + new Thread(FirstJob.getInstance()).getName() +
                        nameOfCurrentThread + Thread.currentThread().getName());
            }
        };
        //3
        new Thread(runnable1," CUSTOM NAME FOR 3").start();

        final Runnable runnable2 = () -> log.println("4: " + nameRunnable +
                new Thread(FirstJob.getInstance()).getName() + nameOfCurrentThread +
                Thread.currentThread().getName());
        //4
        new Thread(runnable2, " 4 CUSTOM NAME").start();
    }
}
