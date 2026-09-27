package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class WhataSauSaGeItsAllMeat {

        static final int[] H = {0, 3, 5, 6, 9, 10, 12, 15};
        static int[] a;
        static int[][] tree;
        static int size;

        static boolean good(int x) {
            return x % 3 == 0;
        }

        static void makeLeaf(int node, int value) {
            for (int i = 0; i < 8; i++) {
                int v = value ^ H[i];
                tree[node][i] = good(v) ? 1 : 0;
            }
        }

        static void merge(int node) {
            int[] left = tree[node << 1];
            int[] right = tree[node << 1 | 1];
            int[] cur = tree[node];

            Arrays.fill(cur, -1_000_000);

            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    int z = x ^ y;
                    cur[z] = Math.max(cur[z], left[x] + right[y]);
                }
            }
        }

        static void build(int node, int l, int r) {
            if (l == r) {
                makeLeaf(node, a[l]);
                return;
            }

            int mid = (l + r) >>> 1;

            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);

            merge(node);
        }

        static void update(int node, int l, int r, int pos, int value) {
            if (l == r) {
                makeLeaf(node, value);
                return;
            }

            int mid = (l + r) >>> 1;

            if (pos <= mid)
                update(node << 1, l, mid, pos, value);
            else
                update(node << 1 | 1, mid + 1, r, pos, value);

            merge(node);
        }

        public static void main(String[] args) throws Exception {
            FastScanner fs = new FastScanner(System.in);
            StringBuilder out = new StringBuilder();

            int t = fs.nextInt();

            while (t-- > 0) {
                int n = fs.nextInt();
                int q = fs.nextInt();

                a = new int[n];

                for (int i = 0; i < n; i++)
                    a[i] = fs.nextInt();

                size = 1;
                while (size < n)
                    size <<= 1;

                tree = new int[size << 1][8];

                // Initialize unused leaves.
                for (int i = 0; i < size; i++) {
                    if (i < n) {
                        makeLeaf(size + i, a[i]);
                    } else {
                        // Identity element: XOR = 0, score = 0
                        tree[size + i][0] = 0;
                        for (int j = 1; j < 8; j++)
                            tree[size + i][j] = -1_000_000;
                    }
                }

                for (int i = size - 1; i > 0; i--)
                    merge(i);

                out.append(tree[1][0]).append(' ');

                while (q-- > 0) {
                    int p = fs.nextInt() - 1;
                    int x = fs.nextInt();

                    a[p] = x;
                    update(1, 0, size - 1, p, x);

                    out.append(tree[1][0]).append(' ');
                }

                out.append('\n');
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

