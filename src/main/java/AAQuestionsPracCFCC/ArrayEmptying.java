package AAQuestionsPracCFCC;

import java.io.*;
import java.util.*;

public class ArrayEmptying {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder ans = new StringBuilder();

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                if (k < 0) {
                    System.out.println(-1);
                    return;
                }

                int[] a = new int[n];
                st = new StringTokenizer(br.readLine());

                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(a);

                long operations = 0;
                for (int i = n - 1; i >= 0; i--) {
                    while (a[i] > k) {
                        a[i] = (a[i] + 1) / 2;
                        operations++;
                        k++;
                    }
                    operations++;
                    k++;
                }

                ans.append(operations).append('\n');
            }

            System.out.print(ans);
        }
    }