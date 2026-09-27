package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;

public class CleanSubstrings {static class SegTree {
    int[] zero, one;
    boolean[] lazy;

    SegTree(int n) {
        zero = new int[4 * n];
        one = new int[4 * n];
        lazy = new boolean[4 * n];
    }

    void build(int node, int l, int r, int[] p) {
        if (l == r) {
            if (p[l] == 0) zero[node] = 1;
            else one[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, p);
        build(node * 2 + 1, mid + 1, r, p);

        pull(node);
    }

    void pull(int node) {
        zero[node] = zero[node * 2] + zero[node * 2 + 1];
        one[node] = one[node * 2] + one[node * 2 + 1];
    }

    void flipNode(int node) {
        int temp = zero[node];
        zero[node] = one[node];
        one[node] = temp;
        lazy[node] = !lazy[node];
    }

    void push(int node) {
        if (lazy[node]) {
            flipNode(node * 2);
            flipNode(node * 2 + 1);
            lazy[node] = false;
        }
    }

    void flip(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return;

        if (ql <= l && r <= qr) {
            flipNode(node);
            return;
        }

        push(node);

        int mid = (l + r) / 2;

        flip(node * 2, l, mid, ql, qr);
        flip(node * 2 + 1, mid + 1, r, ql, qr);

        pull(node);
    }

    void flip(int l, int r, int n) {
        if (l <= r)
            flip(1, 0, n - 1, l, r);
    }

    long oddSubarrays() {
        return (long) zero[1] * one[1];
    }
}

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            int n = fs.nextInt();
            int q = fs.nextInt();

            String s = fs.next();


            int[] d = new int[Math.max(1, n - 1)];

            long transitionSum = 0;

            for (int i = 0; i < n - 1; i++) {
                d[i] = s.charAt(i) != s.charAt(i + 1) ? 1 : 0;

                if (d[i] == 1) {
                    long pos = i + 1;
                    transitionSum += pos * (n - pos);
                }
            }


            int[] prefix = new int[n];

            for (int i = 1; i < n; i++)
                prefix[i] = prefix[i - 1] ^ d[i - 1];

            SegTree tree = new SegTree(n);
            tree.build(1, 0, n - 1, prefix);


            long odd = tree.oddSubarrays();
            long answer = (transitionSum + odd) / 2;

            out.append(answer).append(' ');

            while (q-- > 0) {

                int pos = fs.nextInt() - 1;



                if (pos > 0) {
                    int edge = pos - 1;

                    if (d[edge] == 1) {
                        d[edge] = 0;
                        transitionSum -= (long) (edge + 1) * (n - edge - 1);
                    } else {
                        d[edge] = 1;
                        transitionSum += (long) (edge + 1) * (n - edge - 1);
                    }


                    tree.flip(edge + 1, n - 1, n);
                }

                if (pos < n - 1) {
                    int edge = pos;

                    if (d[edge] == 1) {
                        d[edge] = 0;
                        transitionSum -= (long) (edge + 1) * (n - edge - 1);
                    } else {
                        d[edge] = 1;
                        transitionSum += (long) (edge + 1) * (n - edge - 1);
                    }

                    tree.flip(edge + 1, n - 1, n);
                }

                odd = tree.oddSubarrays();
                answer = (transitionSum + odd) / 2;

                out.append(answer).append(' ');
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

        String next() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
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