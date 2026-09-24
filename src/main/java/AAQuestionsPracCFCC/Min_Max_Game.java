//package A_QuestionsPrac;

import java.util.Scanner;

public class Min_Max_Game {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();

                int ones = 0;

                for (int i = 0; i < n; i++) {
                    int x = sc.nextInt();

                    if (x == 1) {
                        ones++;
                    }
                }

                int zeros = n - ones;

                if (ones >= zeros) {
                    System.out.println("Bessie");
                } else {
                    System.out.println("Elsie");
                }
            }

            sc.close();
        }
    }
