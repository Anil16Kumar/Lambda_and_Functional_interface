package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class __Copper__Squander___ {

        static class Connection {

            int from;
            int to;
            long cost;

            Connection(int from, int to, long cost) {
                this.from = from;
                this.to = to;
                this.cost = cost;
            }
        }

        static class UnionFind {

            private final int[] leader;
            private final int[] componentSize;

            UnionFind(int n) {

                leader = new int[n + 1];
                componentSize = new int[n + 1];

                for (int node = 1; node <= n; node++) {
                    leader[node] = node;
                    componentSize[node] = 1;
                }
            }

            int root(int node) {

                if (leader[node] == node) {
                    return node;
                }

                return leader[node] = root(leader[node]);
            }

            boolean connect(int a, int b) {

                a = root(a);
                b = root(b);

                if (a == b) {
                    return false;
                }

                if (componentSize[a] < componentSize[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                leader[b] = a;
                componentSize[a] += componentSize[b];

                return true;
            }
        }

        static class Equation {

            long slope;
            long intercept;

            Equation(long slope, long intercept) {
                this.slope = slope;
                this.intercept = intercept;
            }

            long evaluate(long x) {
                return slope * x + intercept;
            }
        }

        static boolean shouldRemove(
                Equation first,
                Equation second,
                Equation third) {

            return (third.intercept - first.intercept)
                    * (first.slope - second.slope)
                    <=
                    (second.intercept - first.intercept)
                            * (first.slope - third.slope);
        }

        static class ConvexHull {

            ArrayList<Equation> equations = new ArrayList<>();

            void insert(long slope, long intercept) {

                Equation current = new Equation(slope, intercept);

                while (equations.size() >= 2 &&
                        shouldRemove(
                                equations.get(equations.size() - 2),
                                equations.get(equations.size() - 1),
                                current)) {

                    equations.remove(equations.size() - 1);
                }

                equations.add(current);
            }

            long minimumValue(long x) {

                int low = 0;
                int high = equations.size() - 1;

                while (low < high) {

                    int mid = (low + high) >>> 1;

                    if (equations.get(mid).evaluate(x)
                            <= equations.get(mid + 1).evaluate(x)) {

                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }

                return equations.get(low).evaluate(x);
            }
        }

        public static void main(String[] args) throws Exception {

            InputReader reader = new InputReader(System.in);

            StringBuilder output = new StringBuilder();

            int testCases = reader.nextInt();

            while (testCases-- > 0) {

                int vertices = reader.nextInt();
                int edgeCount = reader.nextInt();
                int queryCount = reader.nextInt();

                Connection[] graphEdges = new Connection[edgeCount];

                long totalWeight = 0;

                for (int i = 0; i < edgeCount; i++) {

                    int u = reader.nextInt();
                    int v = reader.nextInt();
                    long weight = reader.nextLong();

                    graphEdges[i] = new Connection(u, v, weight);

                    totalWeight += weight;
                }

                Arrays.sort(graphEdges,
                        (first, second) ->
                                Long.compare(first.cost, second.cost));

                UnionFind dsu = new UnionFind(vertices);

                ArrayList<Long> selectedWeights = new ArrayList<>();

                for (Connection edge : graphEdges) {

                    if (dsu.connect(edge.from, edge.to)) {
                        selectedWeights.add(edge.cost);
                    }
                }

                int mstSize = selectedWeights.size();

                long[] prefixCost = new long[mstSize + 1];

                for (int i = 1; i <= mstSize; i++) {
                    prefixCost[i] =
                            prefixCost[i - 1]
                                    + selectedWeights.get(i - 1);
                }

                ConvexHull hull = new ConvexHull();

                for (int takenEdges = 0; takenEdges <= mstSize; takenEdges++) {

                    long components = vertices - takenEdges;

                    long slope =
                            components * (components - 1L) / 2L;

                    long intercept = prefixCost[takenEdges];

                    hull.insert(slope, intercept);
                }

                for (int i = 0; i < queryCount; i++) {

                    long x = reader.nextLong();

                    long minimumExpense =
                            hull.minimumValue(x);

                    long answer =
                            totalWeight - minimumExpense;

                    output.append(answer);

                    if (i + 1 < queryCount) {
                        output.append(' ');
                    }
                }

                output.append('\n');
            }

            System.out.print(output);
        }

        static class InputReader {

            private final InputStream input;

            private final byte[] buffer = new byte[1 << 16];

            private int pointer;
            private int bytesRead;

            InputReader(InputStream input) {
                this.input = input;
            }

            private int nextByte() throws IOException {

                if (pointer >= bytesRead) {

                    bytesRead = input.read(buffer);
                    pointer = 0;

                    if (bytesRead <= 0) {
                        return -1;
                    }
                }

                return buffer[pointer++];
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }

            long nextLong() throws IOException {

                int ch;

                do {
                    ch = nextByte();
                } while (ch <= ' ');

                long sign = 1;

                if (ch == '-') {
                    sign = -1;
                    ch = nextByte();
                }

                long value = 0;

                while (ch > ' ') {
                    value = value * 10 + (ch - '0');
                    ch = nextByte();
                }

                return value * sign;
            }
        }
    }