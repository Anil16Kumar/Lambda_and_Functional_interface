package A_QuestionsPrac;

import java.util.*;

public class min_matrics {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                if (k < n || k > 2 * n - 1) {
                    System.out.println("-1");
                    continue;
                }
                int[][] a = new int[n][n];

                int extra = k - n;

                int value = 1;
                for (int j = 1; j <= extra; j++) {
                    a[0][j] = value++;
                }


                for (int i = 0; i < n; i++) {
                    a[i][i] = value++;
                }


                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (a[i][j] == 0) {
                            a[i][j] = value++;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            sc.close();
        }
}
