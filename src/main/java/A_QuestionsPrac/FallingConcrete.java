package A_QuestionsPrac;

import java.util.HashSet;
import java.util.Scanner;

public class FallingConcrete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            HashSet<Long> set = new HashSet<>();

            int ballast = 0;

            for (int i = 1; i <= n; i++) {
                long a = scanner.nextLong();

                long value = a - i;
                set.add(value);
            }

            int answer = 0;

            for (long value : set) {

                if (!set.contains(value - 1)) {

                    int length = 1;
                    long current = value;

                    while (set.contains(current + 1)) {
                        current++;
                        length++;
                    }

                    answer = Math.max(answer, length);
                }
            }

            System.out.println(answer);
        }
    }
}