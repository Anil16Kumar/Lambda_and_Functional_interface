package AAQuestionsPracCFCC;

import java.util.Scanner;

public class TurnIntoaPalindrome {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                char c = sc.next().charAt(0);

                String s = sc.next();

                int coins = 0;

                for (int i = 0; i < n / 2; i++) {

                    char left = s.charAt(i);
                    char right = s.charAt(n - i - 1);

                    if (left == right) {
                    }
                    else if (left == c || right == c) {
                        coins += 1;
                    }
                    else {
                        coins += 2;
                    }
                }

                System.out.println(coins);
            }
            sc.close();
        }
    }