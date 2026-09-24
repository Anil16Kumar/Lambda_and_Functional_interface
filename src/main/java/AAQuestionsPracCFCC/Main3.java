package AAQuestionsPracCFCC;


import java.io.*;
import java.util.*;

public class Main3 {

    static final long MOD = 998244353L;
    static final int MAXN = 200000;

    static long[] fact = new long[MAXN + 1];
    static long[] invFact = new long[MAXN + 1];

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        precomputeFactorials();

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            int n = fs.nextInt();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            Arrays.sort(a);

            boolean distinct = true;

            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    distinct = false;
                    break;
                }
            }

            if (!distinct) {
                out.append("-1\n");
                continue;
            }

            if (n == 1) {
                out.append("0\n");
                continue;
            }


            long[] suffixSum = new long[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                suffixSum[i] = (suffixSum[i + 1] + a[i]) % MOD;
            }

            long answer = 0;


            for (int i = 0; i < n - 1; i++) {

                long choices = n - i - 1;

                long sumParents =
                        (suffixSum[i + 1]
                                - (choices % MOD) * (a[i] % MOD)) % MOD;

                if (sumParents < 0) {
                    sumParents += MOD;
                }


                long ways = fact[n - 1] * modInverse(choices) % MOD;

                long contribution = ways * sumParents % MOD;

                answer += contribution;

                if (answer >= MOD) {
                    answer -= MOD;
                }
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }


    static void precomputeFactorials() {

        fact[0] = 1;

        for (int i = 1; i <= MAXN; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAXN] = modInverse(fact[MAXN]);

        for (int i = MAXN; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }


    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    static long power(long base, long exponent) {

        long result = 1;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exponent >>= 1;
        }

        return result;
    }


    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
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