package AAQuestionsPracCFCC;

import java.util.Scanner;

public class SauSaGeBank {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();

                int ans = (1 << (n - k + 1)) + 2 * (k - 1);

                System.out.println(ans);
            }
        }
    }
