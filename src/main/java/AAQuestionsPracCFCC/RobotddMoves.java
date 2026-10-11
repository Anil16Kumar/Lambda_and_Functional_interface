package AAQuestionsPracCFCC;

import java.util.Scanner;

public class RobotddMoves {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (a == 0 && b == 0) {
                    System.out.println(0);
                } else if (b > a + 1) {
                    System.out.println(-1);
                } else {
                    if ((a - b) % 2 == 0) {
                        System.out.println(a);
                    } else {
                        System.out.println(a + 1);
                    }
                }
            }

            sc.close();
        }
    }