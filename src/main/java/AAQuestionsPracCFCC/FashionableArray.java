package AAQuestionsPracCFCC;

import java.util.*;

public class FashionableArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] frequency = new int[101];
            boolean[] used = new boolean[101];

            for (int x : a) {
                frequency[x]++;
                used[x] = true;
            }

            int[] currentFreq = new int[101];
            int[] answer = new int[n];

            for (int pos = 0; pos < n; pos++) {

                int bestValue = -1;
                int bestMode = -1;

                // Try every value which is still available
                for (int x = 1; x <= 100; x++) {

                    if (!used[x] || frequency[x] == 0) {
                        continue;
                    }

                    // Temporarily add x
                    currentFreq[x]++;

                    int maxFrequency = 0;
                    int mode = 0;

                    for (int v = 1; v <= 100; v++) {
                        if (currentFreq[v] > maxFrequency) {
                            maxFrequency = currentFreq[v];
                            mode = v;
                        } else if (currentFreq[v] == maxFrequency
                                && currentFreq[v] > 0
                                && v > mode) {
                            mode = v;
                        }
                    }

                    // Remove temporary addition
                    currentFreq[x]--;

                    if (mode > bestMode ||
                            (mode == bestMode && x > bestValue)) {

                        bestMode = mode;
                        bestValue = x;
                    }
                }

                answer[pos] = bestValue;

                // Actually take this value
                frequency[bestValue]--;
                currentFreq[bestValue]++;

                if (frequency[bestValue] == 0) {
                    used[bestValue] = false;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(answer[i]);

                if (i < n - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}