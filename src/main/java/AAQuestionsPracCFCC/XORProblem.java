package AAQuestionsPracCFCC;

import java.io.*;
import java.util.Arrays;

public class XORProblem {

    static int n;
    static long[] L, R, pref;
    static long m;

    static long P(long x) {
        if (x <= 0) return 0;

        int lo = 0, hi = n - 1, idx = -1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (L[mid] <= x) {
                idx = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (idx < 0) return 0;

        return pref[idx] + Math.min(x, R[idx]) - L[idx] + 1;
    }

    static long f(long s) {
        return P(s + m - 1) - P(s - 1);
    }

    public static void main(String[] args) throws Exception {

        DataInputStream in =
                new DataInputStream(new BufferedInputStream(System.in, 1 << 16));

        int t = (int) nextLong(in);

        StringBuilder sb = new StringBuilder();

        final long LIM = 1000000000000000000L;

        while (t-- > 0) {

            n = (int) nextLong(in);
            m = nextLong(in);
            long k = nextLong(in);

            L = new long[n];
            R = new long[n];
            pref = new long[n];

            long run = 0;

            for (int i = 0; i < n; i++) {
                L[i] = nextLong(in);
                R[i] = nextLong(in);

                pref[i] = run;
                run += R[i] - L[i] + 1;
            }

            long[] c = new long[4 * n + 1];
            int cs = 0;

            c[cs++] = 1;

            for (int i = 0; i < n; i++) {

                long[] cand = {
                        L[i],
                        R[i] + 1,
                        L[i] - m,
                        R[i] + 1 - m
                };

                for (long v : cand) {
                    if (v >= 1) {
                        c[cs++] = v;
                    }
                }
            }

            long[] cc = Arrays.copyOf(c, cs);

            Arrays.sort(cc);

            int u = 0;

            for (int i = 0; i < cs; i++) {
                if (i == 0 || cc[i] != cc[i - 1]) {
                    cc[u++] = cc[i];
                }
            }

            long fallback = -1;
            long answer = -1;

            for (int j = 0; j < u && answer < 0; j++) {

                long a = cc[j];
                long b = (j + 1 < u) ? cc[j + 1] : LIM;

                long fa = f(a);

                long d = 0;

                if (b > a) {
                    d = f(a + 1) - fa;
                }

                if (d == 0) {

                    if (fa == k) {

                        long s = ((a + 10) / 11) * 11;

                        if (s <= b) {
                            answer = s;
                        } else if (fallback < 0) {
                            fallback = a;
                        }
                    }

                } else {

                    long tt = (k - fa) * d;

                    if (tt >= 0 && tt <= b - a) {

                        long s = a + tt;

                        if (s % 11 == 0) {
                            answer = s;
                        } else if (fallback < 0) {
                            fallback = s;
                        }
                    }
                }
            }

            if (answer < 0) {
                answer = fallback;
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }

    private static long nextLong(DataInputStream in) throws IOException {

        long ret = 0;

        int b = in.read();

        while (b < '0') {
            b = in.read();
        }

        while (b >= '0') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }

        return ret;
    }
}