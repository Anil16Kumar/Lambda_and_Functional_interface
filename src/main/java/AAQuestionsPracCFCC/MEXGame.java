//package AAQuestionsPracCFCC;

import java.io.*;
import java.util.*;

public class MEXGame {

        public static void main(String[] args) throws IOException {
            DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
            int t = nextInt(in);
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int n = nextInt(in);
                int k = nextInt(in);
                int[] cnt = new int[n + 2];
                for (int i = 0; i < n; i++) {
                    cnt[nextInt(in)]++;
                }
                boolean ans = false;
                for (int v = 0; v <= n; v++) {
                    if (cnt[v] >= 2 * k) continue;
                    if (cnt[v] == 2 * k - 1) ans = true;
                    break;
                }
                sb.append(ans ? "YES" : "NO").append('\n');
            }
            System.out.print(sb);
        }

        private static int nextInt(DataInputStream in) throws IOException {
            int ret = 0;
            int b = in.read();
            while (b < '0') b = in.read();
            while (b >= '0') {
                ret = ret * 10 + (b - '0');
                b = in.read();
            }
            return ret;
        }
    }