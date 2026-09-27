package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class KIsImportant {

        static class Fenwick {
            int n;
            int[] bit;

            Fenwick(int n) {
                this.n = n;
                bit = new int[n + 1];
                for (int i = 1; i <= n; i++)
                    add(i, 1);
            }

            void add(int i, int val) {
                while (i <= n) {
                    bit[i] += val;
                    i += i & -i;
                }
            }

            // returns 0-based index of kth active element
            int kth(int k) {
                int idx = 0;
                int step = Integer.highestOneBit(n);

                while (step > 0) {
                    int next = idx + step;
                    if (next <= n && bit[next] < k) {
                        idx = next;
                        k -= bit[next];
                    }
                    step >>= 1;
                }

                return idx; // 0-based
            }
        }

        public static void main(String[] args) throws Exception {
            FastScanner fs = new FastScanner(System.in);
            StringBuilder out = new StringBuilder();

            int t = fs.nextInt();

            while (t-- > 0) {
                int n = fs.nextInt();
                int k = fs.nextInt();

                long[] a = new long[n];
                for (int i = 0; i < n; i++)
                    a[i] = fs.nextLong();

                Fenwick fw = new Fenwick(n);

                long ans = 0;
                int m = n;

                while (m >= k) {
                    // kth element from left
                    int left = fw.kth(k);

                    // kth element from right = (m-k+1)-th from left
                    int right = fw.kth(m - k + 1);

                    if (a[left] >= a[right]) {
                        ans += a[left];
                        fw.add(left + 1, -1);
                    } else {
                        ans += a[right];
                        fw.add(right + 1, -1);
                    }

                    m--;
                }

                out.append(ans).append('\n');
            }

            System.out.print(out);
        }

        static class FastScanner {
            private final InputStream in;
            private final byte[] buffer = new byte[1 << 16];
            private int ptr = 0, len = 0;

            FastScanner(InputStream in) {
                this.in = in;
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
                int c;
                do {
                    c = read();
                } while (c <= ' ');

                long res = 0;
                while (c > ' ') {
                    res = res * 10 + c - '0';
                    c = read();
                }
                return res;
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }
        }
    }