package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ThreadStatesExample {

    public static void main(String[] args) throws InterruptedException {
        // print information about main thread
        printThreadInfo(Thread.currentThread());

        // create a runnable object that prints thread information
        Runnable runnablePrintInfo = () -> {
            Thread currentThread = Thread.currentThread();
            printThreadInfo(currentThread);
        };

        // create new thread and print info before start()
        Thread firstThread = new Thread(runnablePrintInfo, "First thread");
        printThreadInfo(firstThread);
        // then, start new thread. This thread must print info without any other calling
        firstThread.start();

        // create another thread without specific name and start it
        Thread secondThreat = new Thread(runnablePrintInfo);
        secondThreat.start();
        // put main thread to sleep
        Thread.sleep(2000);

        // change name of the second thread and print its info
        secondThreat.setName("Second Thread renamed");
        printThreadInfo(secondThreat);

        // print current thread info
        printThreadInfo(Thread.currentThread());
    }

    private static void printThreadInfo(Thread thread) {
        log.printf("%s is %salive and in %s state and priority is %d \n",
                thread.getName(),
                thread.isAlive() ? "" : "not ",
                thread.getState(),
                thread.getPriority());
    }
}
