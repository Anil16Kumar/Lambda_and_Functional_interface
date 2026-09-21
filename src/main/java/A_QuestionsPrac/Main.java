//package A_QuestionsPrac;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            List<Integer> indices = new ArrayList<>();

            // Store positions which are not already correct
            for (int i = 0; i < n; i++) {
                if (p[i] != i + 1) {
                    indices.add(i + 1); // 1-based index
                }
            }

            boolean possible = true;

            /*
             * If indices = [i1, i2, ..., im],
             * then after reversing these positions:
             *
             * i1 -> im
             * i2 -> i(m-1)
             * ...
             *
             * Therefore:
             * p[ij] must equal indices[m-1-j].
             */
            for (int j = 0; j < indices.size(); j++) {
                int index = indices.get(j);

                if (p[index - 1] != indices.get(indices.size() - 1 - j)) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }
}