package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;

public class BackroomsHill { public static void main(String[] args) throws Exception {

    FastScanner fs = new FastScanner();
    StringBuilder out = new StringBuilder();

    int T = fs.nextInt();

    while (T-- > 0) {

        int n = fs.nextInt();

        int[] posParity = new int[n + 1];
        int maxPos = 0;

        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            posParity[x] = i & 1;

            if (x == n)
                maxPos = i;
        }

        if (n <= 2) {
            out.append("YES\n");
            continue;
        }


        int k = n / 2;

        if ((k & 1) != (maxPos & 1))
            k--;

        int left = k;
        int right = n - k - 1;


        final int INF = 1_000_000_000;

        int[] lo = {INF, INF};
        int[] hi = {-INF, -INF};

        lo[0] = hi[0] = 0;

        for (int value = 1; value < n; value++) {

            int parity = posParity[value];

            int[] nlo = {INF, INF};
            int[] nhi = {-INF, -INF};

            int processed = value - 1;

            for (int p = 0; p < 2; p++) {

                if (lo[p] > hi[p])
                    continue;


                if (parity == p) {

                    int low = lo[p] + 1;
                    int high = Math.min(hi[p] + 1, left);

                    int np = p ^ 1;

                    if ((low & 1) != np)
                        low++;

                    if ((high & 1) != np)
                        high--;

                    if (low <= high) {
                        nlo[np] = Math.min(nlo[np], low);
                        nhi[np] = Math.max(nhi[np], high);
                    }
                }


                int required =
                        (n - 1 + processed - p) & 1;

                if (parity == required) {

                    int low = Math.max(
                            lo[p],
                            processed - right + 1
                    );

                    int high = Math.min(hi[p], left);

                    if ((low & 1) != p)
                        low++;

                    if ((high & 1) != p)
                        high--;

                    if (low <= high) {
                        nlo[p] = Math.min(nlo[p], low);
                        nhi[p] = Math.max(nhi[p], high);
                    }
                }
            }

            lo = nlo;
            hi = nhi;
        }


        boolean possible =
                lo[left & 1] <= left &&
                        left <= hi[left & 1];

        out.append(possible ? "YES\n" : "NO\n");
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

            int res = 0;

            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }

            return res;
        }
    }
}