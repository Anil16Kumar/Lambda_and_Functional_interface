package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class MEX_Replacement {

        static class FastScanner {
            private final InputStream in = System.in;
            private final byte[] buffer = new byte[1 << 16];
            private int ptr = 0, len = 0;

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

                long res = 0;

                while (c > ' ') {
                    res = res * 10 + (c - '0');
                    c = read();
                }

                return res;
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }
        }

        public static void main(String[] args) throws Exception {

            FastScanner fs = new FastScanner();
            StringBuilder out = new StringBuilder();

            int t = fs.nextInt();

            while (t-- > 0) {

                int n = fs.nextInt();


                TreeMap<Long, Long> powers = new TreeMap<>();

                long maxValue = 0;

                for (int i = 0; i < n; i++) {

                    long x = fs.nextLong();
                    long y = fs.nextLong();

                    maxValue = Math.max(maxValue, x);

                    long exponent;

                    if (x == 0) {
                        exponent = 0;
                    } else {
                        exponent = x - 1;
                    }

                    powers.merge(exponent, y, Long::sum);
                }


                long highestExponent = 0;

                while (!powers.isEmpty()) {

                    Map.Entry<Long, Long> entry = powers.pollFirstEntry();

                    long exponent = entry.getKey();
                    long count = entry.getValue();

                    if (count == 0) {
                        continue;
                    }

                    if ((count & 1L) != 0) {
                        highestExponent = Math.max(highestExponent, exponent);
                    }

                    long carry = count / 2;

                    if (carry > 0) {
                        powers.merge(exponent + 1, carry, Long::sum);
                    }
                }

                long mexoramax = highestExponent + 1;

                out.append(mexoramax).append('\n');
            }

            System.out.print(out);
        }
    }