package AAQuestionsPracCFCC;

import java.util.ArrayList;
import java.util.Scanner;

public class HypercarpAndTheControlPanel {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int TestsNumT = sc.nextInt();

            StringBuilder out = new StringBuilder();

            while (TestsNumT-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                ArrayList<Integer> colors = new ArrayList<>();
                ArrayList<Integer> len = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (colors.isEmpty() || colors.get(colors.size() - 1) != a[i]) {
                        colors.add(a[i]);
                        len.add(1);
                    } else {
                        len.set(len.size() - 1, len.get(len.size() - 1) + 1);
                    }
                }

                int m = colors.size();
                int ans = m;

                boolean gain2 = false;

                for (int i = 0; i + 1 < m; i++) {
                    if (len.get(i) >= 2 && len.get(i + 1) >= 2) {
                        gain2 = true;
                        break;
                    }
                }

                if (gain2) {
                    ans = m + 2;
                } else {
                    boolean gain1 = false;

                    for (int i = 0; i < m; i++) {
                        if (len.get(i) < 2) continue;

                        boolean ok = false;

                        if (i > 0) {
                            if (i == 1 || !colors.get(i - 2).equals(colors.get(i))) {
                                ok = true;
                            }
                        }

                        if (i < m - 1) {
                            if (i == m - 2 || !colors.get(i + 2).equals(colors.get(i))) {
                                ok = true;
                            }
                        }

                        if (ok) {
                            gain1 = true;
                            break;
                        }
                    }

                    if (gain1) {
                        ans = m + 1;
                    }
                }

                out.append(ans).append('\n');
            }

            System.out.print(out);
        }
    }