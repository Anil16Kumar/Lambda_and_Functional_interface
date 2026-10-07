package AAQuestionsPracCFCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class __Tea__Blend___ {

        private static final int LIMIT = 1000000;

        private static final int[] smallestPrime = new int[LIMIT + 1];
        private static final long[] randomValue = new long[LIMIT + 1];

        private static long generateHash(long value) {

            value += 0x9e3779b97f4a7c15L;
            value = (value ^ (value >>> 30)) * 0xbf58476d1ce4e5b9L;
            value = (value ^ (value >>> 27)) * 0x94d049bb133111ebL;

            return value ^ (value >>> 31);
        }

        private static void initializePrimes() {

            for (int number = 2; number <= LIMIT; number++) {

                if (smallestPrime[number] != 0) {
                    continue;
                }

                smallestPrime[number] = number;
                randomValue[number] = generateHash(number);

                if ((long) number * number > LIMIT) {
                    continue;
                }

                int multiple = number * number;

                while (multiple <= LIMIT) {

                    if (smallestPrime[multiple] == 0) {
                        smallestPrime[multiple] = number;
                    }

                    multiple += number;
                }
            }

            smallestPrime[1] = 1;
        }

        private static long compress(int value) {

            long encoded = 0;

            while (value > 1) {

                int factor = smallestPrime[value];
                boolean oddPower = false;

                while (value % factor == 0) {

                    value /= factor;
                    oddPower = !oddPower;
                }

                if (oddPower) {
                    encoded ^= randomValue[factor];
                }
            }

            return encoded;
        }

        public static void main(String[] args) throws Exception {

            initializePrimes();

            FastInput input = new FastInput(System.in);

            int testCases = input.nextInt();

            StringBuilder output = new StringBuilder();

            while (testCases-- > 0) {

                int size = input.nextInt();

                long[] encodedValues = new long[size + 1];

                for (int idx = 1; idx <= size; idx++) {
                    encodedValues[idx] = compress(input.nextInt());
                }

                Map<Long, Long> counter = new HashMap<>();

                long prefixXor = 0;

                for (int idx = 1; idx <= size; idx++) {

                    prefixXor ^= encodedValues[idx];

                    counter.put(
                            prefixXor,
                            counter.getOrDefault(prefixXor, 0L) + 1
                    );
                }

                long total = 0;

                for (int idx = 1; idx <= size; idx++) {

                    total += counter.getOrDefault(
                            encodedValues[idx],
                            0L
                    );
                }

                output.append(total).append('\n');
            }

            System.out.print(output);
        }

        static class FastInput {

            private final InputStream stream;

            private final byte[] bytes = new byte[1 << 16];

            private int pointer;
            private int size;

            FastInput(InputStream stream) {
                this.stream = stream;
            }

            private int nextByte() throws IOException {

                if (pointer >= size) {

                    size = stream.read(bytes);
                    pointer = 0;

                    if (size < 0) {
                        return -1;
                    }
                }

                return bytes[pointer++];
            }

            int nextInt() throws IOException {

                int ch;

                do {
                    ch = nextByte();
                } while (ch <= 32);

                int sign = 1;

                if (ch == '-') {
                    sign = -1;
                    ch = nextByte();
                }

                int value = 0;

                while (ch > 32) {
                    value = value * 10 + (ch - '0');
                    ch = nextByte();
                }

                return value * sign;
            }
        }
    }