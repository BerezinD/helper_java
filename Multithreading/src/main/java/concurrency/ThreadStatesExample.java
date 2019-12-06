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
        log.println("-------interrupted() example-------");
        printCurrentThreadIsInterrupted();
        Thread.currentThread().interrupt();
        printCurrentThreadIsInterrupted();
        printCurrentThreadIsInterrupted();
        log.println("-------interrupted() example-------");
        // put main thread to sleep
        Thread.sleep(2000);

        // change name of the second thread and print its info
        secondThreat.setName("Second Thread renamed");
        printThreadInfo(secondThreat);

        // print current thread info
        printThreadInfo(Thread.currentThread());

        // join() example:
        CountingThread countOne = new CountingThread("countOne");
        CountingThread countTwo = new CountingThread("countTwo");
        CountingThread countThree = new CountingThread("countThree");
        // begin countdown!
        countOne.start();
        // then, wait until countOne thread is done
        countOne.join();
        // to this point we can't reach while countOne still running
        countTwo.start();
        countThree.start();
    }

    private static void printCurrentThreadIsInterrupted() {
        log.println("Current thread is " + (Thread.interrupted() ? "" : "not ") + "interrupted");
    }

    private static void printThreadInfo(Thread thread) {
        log.printf("%s is %salive and in %s state and priority is %d \n",
                thread.getName(),
                thread.isAlive() ? "" : "not ",
                thread.getState(),
                thread.getPriority());
    }
}
