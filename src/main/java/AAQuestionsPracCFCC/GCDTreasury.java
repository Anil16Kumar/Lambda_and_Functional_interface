package AAQuestionsPracCFCC;
import java.io.*;
import java.util.*;

public class GCDTreasury {

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();
        StringBuilder out = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int x = sc.nextInt();

            int MAX = 300000;
            int[] a = new int[n];
            long[] freq = new long[MAX + 1];

            // Distinct gcd(ai, x)
            boolean[] present = new boolean[MAX + 1];

            int maxA = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                freq[a[i]] += a[i];
                maxA = Math.max(maxA, a[i]);

                present[gcd(a[i], x)] = true;
            }

            // All divisors of x
            ArrayList<Integer> divisors = new ArrayList<>();

            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    divisors.add(d);

                    if (d * d != x)
                        divisors.add(x / d);
                }
            }

            // reachable[i] -> divisors.get(i) can be reached
            boolean[] reachable = new boolean[divisors.size()];

            HashMap<Integer, Integer> id = new HashMap<>();

            for (int i = 0; i < divisors.size(); i++)
                id.put(divisors.get(i), i);

            reachable[id.get(x)] = true;

            /*
             * Find all reachable GCD states.
             *
             * There are very few divisors of x (<= ~180),
             * so O(D^2) is tiny.
             */
            boolean changed = true;

            while (changed) {
                changed = false;

                for (int i = 0; i < divisors.size(); i++) {

                    if (!reachable[i])
                        continue;

                    int cur = divisors.get(i);

                    for (int b : divisors) {

                        if (!present[b])
                            continue;

                        int next = gcd(cur, b);
                        int idx = id.get(next);

                        if (!reachable[idx]) {
                            reachable[idx] = true;
                            changed = true;
                        }
                    }
                }
            }

            long answer = 0;

            /*
             * For a reachable g > 1, every pile divisible by g
             * can eventually be completely stolen.
             */
            for (int i = 0; i < divisors.size(); i++) {

                if (!reachable[i])
                    continue;

                int g = divisors.get(i);

                if (g == 1)
                    continue;

                long sum = 0;

                for (int j = g; j <= maxA; j += g)
                    sum += freq[j];

                answer = Math.max(answer, sum);
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int num = 0;

            while (c > ' ') {
                num = num * 10 + c - '0';
                c = read();
            }

            return num;
        }
    }
}