package references;

import com.sun.istack.internal.Nullable;

public class HeavyList {

    private byte[] mega = new byte[1000];
    HeavyList next = null;

    public HeavyList(int number, @Nullable HeavyList prev) {
        for (int i = 0; i < mega.length; i++) {
            mega[i] = (byte) (number % 256);
        }
        if (prev != null) {
            prev.next = this;
        }
    }

    public HeavyList getNext() {
        return next;
    }

    public HeavyList dropNext() {
        if (next == null || next.next == null)
            return null;
        HeavyList res = next;
        next = next.next;
        return res;
    }
}
