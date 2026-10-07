package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;

public class Precision_Alignment__ {

        private static final long LIMIT = (long) 4e18;

        public static void main(String[] args) throws Exception {

            Reader scan = new Reader(System.in);

            int tests = scan.nextInt();

            StringBuilder result = new StringBuilder();

            while (tests-- > 0) {

                int size = scan.nextInt();
                long budget = scan.nextLong();

                long[] totals = new long[size];
                long[] bonusCost = new long[size];
                int[] category = new int[size];

                int idx = 0;

                while (idx < size) {

                    long x = scan.nextLong();
                    long y = scan.nextLong();
                    long z = scan.nextLong();

                    totals[idx] = x + y + z;

                    if (x == y && y == z) {

                        category[idx] = 2;

                    } else if (x <= y && y <= z) {

                        category[idx] = 1;

                        long gap1 = y - x;
                        long gap2 = z - y;

                        bonusCost[idx] = 2L * (Math.min(gap1, gap2) + 1);

                    } else {

                        category[idx] = 0;
                    }

                    idx++;
                }

                long left = -LIMIT;
                long right = LIMIT;

                while (right - left > 1) {

                    long candidate = left + (right - left) / 2;

                    if (isPossible(candidate, budget, totals, bonusCost, category)) {
                        left = candidate;
                    } else {
                        right = candidate;
                    }
                }

                result.append(left).append('\n');
            }

            System.out.print(result);
        }

        private static boolean isPossible(long value,
                                          long available,
                                          long[] totals,
                                          long[] bonusCost,
                                          int[] category) {

            long spent = 0;

            for (int i = 0; i < totals.length; i++) {

                if (totals[i] >= value) {
                    continue;
                }

                long deficit = value - totals[i];

                if (category[i] == 2) {
                    return false;
                }

                long requiredAmount =
                        (category[i] == 1)
                                ? deficit + bonusCost[i]
                                : deficit;

                spent += requiredAmount;

                if (spent > available) {
                    return false;
                }
            }

            return true;
        }

        static class Reader {

            private final InputStream stream;
            private final byte[] data = new byte[65536];

            private int current;
            private int bytesRead;

            Reader(InputStream stream) {
                this.stream = stream;
            }

            private int nextByte() throws IOException {

                if (current >= bytesRead) {

                    bytesRead = stream.read(data);
                    current = 0;

                    if (bytesRead <= 0) {
                        return -1;
                    }
                }

                return data[current++];
            }

            long nextLong() throws IOException {

                int ch;

                do {
                    ch = nextByte();
                } while (ch <= 32);

                long sign = 1;

                if (ch == '-') {
                    sign = -1;
                    ch = nextByte();
                }

                long number = 0;

                while (ch > 32) {
                    number = number * 10 + ch - '0';
                    ch = nextByte();
                }

                return number * sign;
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }
        }
    }