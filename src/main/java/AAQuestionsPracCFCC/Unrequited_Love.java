package AAQuestionsPracCFCC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Unrequited_Love {

        public static void main(String[] args) throws Exception {

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            int testCount = Integer.parseInt(reader.readLine());

            StringBuilder answer = new StringBuilder();

            while (testCount-- > 0) {

                int size = Integer.parseInt(reader.readLine());

                StringTokenizer tokenizer =
                        new StringTokenizer(reader.readLine());

                long[] numbers = new long[size + 1];

                int position = 1;

                while (position <= size) {
                    numbers[position] = Long.parseLong(tokenizer.nextToken());
                    position++;
                }

                int limit = size - 4;

                long[] generated = new long[limit + 1];

                for (int idx = 1; idx <= limit; idx++) {
                    generated[idx] =
                            numbers[idx]
                                    + numbers[idx + 2]
                                    - numbers[idx + 4];
                }

                Map<Long, Long> occurrences = new HashMap<>();

                long matchingPairs = 0;
                long overlappingPairs = 0;

                int current = 1;

                while (current <= limit) {

                    long currentValue = generated[current];

                    long previousOccurrences =
                            occurrences.getOrDefault(currentValue, 0L);

                    matchingPairs += previousOccurrences;

                    occurrences.put(
                            currentValue,
                            previousOccurrences + 1
                    );

                    if (current >= 3) {
                        if (generated[current - 2] == currentValue) {
                            overlappingPairs++;
                        }
                    }

                    if (current >= 5) {
                        if (generated[current - 4] == currentValue) {
                            overlappingPairs++;
                        }
                    }

                    current++;
                }

                long finalAnswer = matchingPairs - overlappingPairs;

                answer.append(finalAnswer).append('\n');
            }

            System.out.print(answer);
        }
    }
