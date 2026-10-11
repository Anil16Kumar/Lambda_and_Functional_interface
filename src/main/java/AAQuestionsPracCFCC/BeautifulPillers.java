package AAQuestionsPracCFCC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BeautifulPillers {

        static class Operation {
            int type;
            int i, j;

            Operation(int type, int i, int j) {
                this.type = type;
                this.i = i;
                this.j = j;
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            StringBuilder out = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] a = new int[n];

                int mx = 0;
                int pos = 0;

                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());

                    if (a[i] > mx) {
                        mx = a[i];
                        pos = i;
                    }
                }

                List<Operation> piller_operations = new ArrayList<>();

                for (int i = pos - 1; i >= 0; i--) {
                    if (a[i] < a[i + 1]) {
                        piller_operations.add(
                                new Operation(1, i + 1, i + 2));
                    } else {
                        piller_operations.add(
                                new Operation(2, i + 1, i + 2));
                    }
                    a[i] = a[i + 1];
                }

                for (int i = pos + 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        piller_operations.add(
                                new Operation(1, i + 1, i));
                    } else {
                        piller_operations.add(
                                new Operation(2, i + 1, i));
                    }
                    a[i] = a[i - 1];
                }

                out.append(piller_operations.size()).append('\n');

                for (Operation op : piller_operations) {
                    out.append(op.type)
                            .append(' ')
                            .append(op.i)
                            .append(' ')
                            .append(op.j)
                            .append('\n');
                }
            }

            System.out.print(out);
        }
    }