package references;

import java.lang.ref.WeakReference;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ReferencesExample {
    public static void main(String[] args) {
        playWithRef();
    }

    /**
     * This method may print in log one of this (acceptable for HotSpot VM):
     *      false, false (possible output without param)
     *      true, false (-Xcomp)
     *      true, true (without param, or -Xint)
     */
    private static void playWithRef() {
        Object obj = new Object();
        WeakReference<Object> ref = new WeakReference<>(obj);
        log.println(ref.get() != null);
        System.gc();
        log.println(ref.get() != null);
    }
}
