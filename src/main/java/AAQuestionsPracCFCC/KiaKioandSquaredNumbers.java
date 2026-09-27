package AAQuestionsPracCFCC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KiaKioandSquaredNumbers {

        static int next(int x) {
            int sum = 0;

            while (x > 0) {
                int d = x % 10;
                sum += d * d;
                x /= 10;
            }

            return sum;
        }

        static int getState(int x) {
            for (int i = 0; i < 100; i++) {
                x = next(x);
            }
            return x;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();

                Map<Integer, Integer> freq = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    int x = getState(sc.nextInt());
                    freq.put(x, freq.getOrDefault(x, 0) + 1);
                }

                long ans = 0;

                for (int count : freq.values()) {
                    ans += (long) count * (count - 1) / 2;
                }

                System.out.println(ans);
            }

            sc.close();
        }
    }