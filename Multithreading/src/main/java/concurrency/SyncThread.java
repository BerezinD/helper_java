package concurrency;

public class SyncThread extends Thread {
    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                total += i;
                notify();
            }
        }
    }
}
