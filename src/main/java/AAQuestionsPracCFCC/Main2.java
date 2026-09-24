package AAQuestionsPracCFCC;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            // We need the smallest m-1 elements before
            // the chosen last element.
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(
                    Collections.reverseOrder()
            );

            long sum = 0;
            long answer = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {

                // If we use a[i] as the LAST selected element
                // we need m-1 elements before it.
                if (maxHeap.size() == m - 1) {
                    long score = (long) m * a[i] - sum;
                    answer = Math.max(answer, score);
                }

                // Add current element for future positions.
                maxHeap.add(a[i]);
                sum += a[i];

                // Keep only the smallest m-1 elements.
                if (maxHeap.size() > m - 1) {
                    sum -= maxHeap.poll();
                }
            }

            // m = 1 is a special case:
            // score = 1 * b1
            if (m == 1) {
                answer = Long.MIN_VALUE;

                for (long x : a) {
                    answer = Math.max(answer, x);
                }
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }

    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            boolean negative = false;

            if (c == '-') {
                negative = true;
                c = read();
            }

            long result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return negative ? -result : result;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}