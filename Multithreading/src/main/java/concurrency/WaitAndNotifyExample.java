package concurrency;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class WaitAndNotifyExample {

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        syncThread.start();
        synchronized (syncThread) {
            try {
                log.println("wait to another thread by invoke wait() method...");
                syncThread.wait();
            } catch (InterruptedException e) {
                log.println("catch exception " + e.getMessage());
            }
            log.println("total count is: " + syncThread.total);
        }
    }
}
