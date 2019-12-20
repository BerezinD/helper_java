package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ReferencesExample {
    private static final int HOW_MANY = 500_000;

    public static void main(String[] args) {
        playWithRef();
        log.println("---------------------------");
        log.println("Start!");

        ReferenceQueue<HeavyList> queue = new ReferenceQueue();
        Set<Reference<HeavyList>> references = new HashSet<>();

        printMem();
        log.println("Press ^C to break!");
        log.println("\n\nUsed mem");

        long start = System.currentTimeMillis();

        allocationLoop(queue, references, 100);
        log.println("Total time " + (System.currentTimeMillis() - start));
        System.gc();
        int removed = removeRefs(queue, references);

        log.println("Final used mem " + getUsedMem() + "    Refs removed " + removed + "   left " + references.size());
    }

    private static void printMem() {
        /* Total number of processors or cores available to the JVM */
        log.println("Available processors (cores): " +
                Runtime.getRuntime().availableProcessors());

        /* Total amount of free memory available to the JVM */
        log.println("Free memory (bytes): " +
                Runtime.getRuntime().freeMemory());

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        log.println("Maximum memory (bytes): " +
                (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        /* Total memory currently in use by the JVM */
        log.println("Total memory (bytes): " +
                Runtime.getRuntime().totalMemory());
    }

    private static void allocationLoop(ReferenceQueue<HeavyList> queue, Set<Reference<HeavyList>> references, int howManyTimes) {
        HeavyList head = new HeavyList(0, null);
        HeavyList oldTail = head;
        for (int i = 0; i < howManyTimes; i++) {
            HeavyList newTail = allocate(HOW_MANY, oldTail);
            HeavyList curr = oldTail.next;

            while (curr != null) {
//                Reference<HeavyList> reference = new SoftReference<>(curr, queue);
//                Reference<HeavyList> reference = new WeakReference<>(curr, queue);
                Reference<HeavyList> reference = new PhantomReference<>(curr, queue);
                references.add(reference);

                curr = curr.getNext();
            }

            deallocateHalf(head);

            int removed = removeRefs(queue, references);

            //  System.gc();   //uncomment this line to comparing with forced gc
            log.println("used mem " + getUsedMem() + "    Refs removed " + removed + "   left " + references.size());

            oldTail = newTail;
        }
        head = null;
        oldTail = null;
    }

    private static HeavyList allocate(int howMany, HeavyList startFrom) {
        HeavyList curr = startFrom;
        for (int i = 0; i < howMany; i++) {
            curr = new HeavyList(i, curr);
        }
        return curr;
    }

    private static void deallocateHalf(HeavyList head) {
        HeavyList curr = head;

        while (curr != null) {
            curr.dropNext();
            curr = curr.getNext();
        }
    }

    private static int removeRefs(ReferenceQueue queue, Set<Reference<HeavyList>> references) {
        int removed = 0;
        while (true) {
            Reference r = queue.poll();
            if (r == null)
                break;
            references.remove(r);
            removed++;
        }
        return removed;
    }

    private static long getUsedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /**
     * This method may print in log one of this (acceptable for HotSpot VM):
     * false, false (possible output without param)
     * true, false (-Xcomp)
     * true, true (without param, or -Xint)
     */
    private static void playWithRef() {
        Object obj = new Object();
        WeakReference<Object> ref = new WeakReference<>(obj);
        log.println(ref.get() != null);
        System.gc();
        log.println(ref.get() != null);
    }
}
