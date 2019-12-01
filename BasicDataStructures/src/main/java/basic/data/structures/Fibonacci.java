package basic.data.structures;

public class Fibonacci {
    public long fibFormula(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(phi, n)
                / Math.sqrt(5));
    }

    public long fastFibonacciDoubling(int n) {
        long a = 0;
        long b = 1;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            // Loop invariant: a = F(m), b = F(m+1)

            // Double it
            long d = a*((b<<1)-a);
            long e = (a*a)+(b*b);
            a = d;
            b = e;

            // Advance by one conditionally
            if ((n & bit) != 0) {
                long c = a+b;
                a = b;
                b = c;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Fibonacci helper = new Fibonacci();
        System.out.println(helper.fastFibonacciDoubling(1000000));
        System.out.println(helper.fibFormula(100));
    }
}
