package A_QuestionsPrac;

import java.util.Scanner;

public class PrimeDestruction {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {

                int n = scanner.nextInt();
                int k = scanner.nextInt();

                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }

                int[] spf = new int[n + 1];

                for (int i = 2; i <= n; i++) {
                    if (spf[i] == 0) {
                        for (int j = i; j <= n; j += i) {
                            if (spf[j] == 0) {
                                spf[j] = i;
                            }
                        }
                    }
                }

                long[] dp = new long[n + 1];

                for (int x = 1; x <= n; x++) {

                    if (x <= k) {
                        dp[x] = 0;
                        continue;
                    }

                    long best = Long.MAX_VALUE;

                    int temp = x;

                    while (temp > 1) {

                        int p = spf[temp];

                        long operations = 1L + p * dp[x / p];

                        best = Math.min(best, operations);

                        while (temp % p == 0) {
                            temp /= p;
                        }
                    }

                    dp[x] = best;
                }

                long answer = 0;

                int ballast = 0;

                for (int x : a) {
                    answer += dp[x];
                }

                System.out.println(answer);
            }
        }
    }