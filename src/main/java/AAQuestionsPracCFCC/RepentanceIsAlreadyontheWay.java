package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class RepentanceIsAlreadyontheWay {

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
                    if (len <= 0) return -1;
                }
                return buffer[ptr++];
            }

            long nextLong() throws IOException {
                long sign = 1;
                long val = 0;
                int c;

                do {
                    c = read();
                } while (c <= ' ');

                if (c == '-') {
                    sign = -1;
                    c = read();
                }

                while (c > ' ') {
                    val = val * 10 + c - '0';
                    c = read();
                }

                return val * sign;
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }
        }

        static final long NEG = -(long) 4e18;

        public static void main(String[] args) throws Exception {
            FastScanner fs = new FastScanner(System.in);
            StringBuilder out = new StringBuilder();

            int t = fs.nextInt();

            while (t-- > 0) {

                int n = fs.nextInt();

                long[] a = new long[n + 1];
                long[] b = new long[n + 1];

                for (int i = 1; i <= n; i++) a[i] = fs.nextLong();
                for (int i = 1; i <= n; i++) b[i] = fs.nextLong();

                if (n == 1) {
                    long thegrilla = (a[1] == b[1]) ? 2 : 1;
                    out.append(thegrilla).append('\n');
                    continue;
                }

                long[] same = new long[n + 1];
                long[] up = new long[n];
                long[] down = new long[n];

                for (int i = 1; i <= n; i++) {
                    same[i] = (a[i] == b[i]) ? 1 : 0;
                }

                for (int i = 1; i < n; i++) {
                    up[i] = (a[i] == b[i + 1]) ? 1 : 0;
                    down[i] = (b[i] == a[i + 1]) ? 1 : 0;
                }

                long[][] dp = new long[n + 1][4];

                for (int i = 0; i <= n; i++) {
                    Arrays.fill(dp[i], NEG);
                }

                dp[1][1] = same[1];

                for (int col = 1; col < n; col++) {

                    if (dp[col][0] > NEG) {
                        dp[col + 1][0] = Math.max(
                                dp[col + 1][0],
                                dp[col][0] + up[col] + same[col + 1]
                        );
                    }

                    if (dp[col][1] > NEG) {
                        dp[col + 1][1] = Math.max(
                                dp[col + 1][1],
                                dp[col][1] + down[col] + same[col + 1]
                        );

                        dp[col + 1][2] = Math.max(
                                dp[col + 1][2],
                                dp[col][1] + up[col] + down[col]
                        );
                    }

                    if (dp[col][2] > NEG) {
                        dp[col + 1][0] = Math.max(
                                dp[col + 1][0],
                                dp[col][2] + down[col]
                        );

                        dp[col + 1][1] = Math.max(
                                dp[col + 1][1],
                                dp[col][2] + up[col]
                        );
                    }
                }

                long bonus = Math.max(dp[n][0], dp[n][1]);

                long thegrilla = (2L * n - 1) + bonus;

                out.append(thegrilla).append('\n');
            }

            System.out.print(out);
        }
    }