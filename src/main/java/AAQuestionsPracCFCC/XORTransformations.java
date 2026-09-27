package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class XORTransformations {

        static int[] transform(int[] a) {
            int n = a.length;

            int size = n * (n - 1) / 2;
            int[] pairs = new int[size];

            int k = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    pairs[k++] = a[i] ^ a[j];
                }
            }

            Arrays.sort(pairs);

            return Arrays.copyOf(pairs, n);
        }

        static long beauty(int[] a) {
            int min = a[0];
            int max = a[0];

            for (int x : a) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            return (long) max - min;
        }

        static boolean allZero(int[] a) {
            for (int x : a) {
                if (x != 0)
                    return false;
            }
            return true;
        }

        public static void main(String[] args) throws Exception {

            FastScanner fs = new FastScanner();
            StringBuilder out = new StringBuilder();

            int t = fs.nextInt();

            while (t-- > 0) {

                int n = fs.nextInt();
                int q = fs.nextInt();

                int[] a = new int[n];

                for (int i = 0; i < n; i++)
                    a[i] = fs.nextInt();


                ArrayList<Long> ans = new ArrayList<>();

                while (true) {

                    ans.add(beauty(a));

                    if (allZero(a))
                        break;

                    a = transform(a);
                }

                for (int i = 0; i < q; i++) {

                    long x = fs.nextLong();

                    if (x >= ans.size())
                        out.append(0);
                    else
                        out.append(ans.get((int) x));

                    if (i + 1 < q)
                        out.append(' ');
                }

                out.append('\n');
            }

            System.out.print(out);
        }

        static class FastScanner {

            private final InputStream in = System.in;
            private final byte[] buffer = new byte[1 << 16];

            private int ptr = 0;
            private int len = 0;

            private int read() throws IOException {

                if (ptr >= len) {
                    len = in.read(buffer);
                    ptr = 0;

                    if (len <= 0)
                        return -1;
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