package AAQuestionsPracCFCC;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Did_Not_Go_to_Print {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            int testCases = input.nextInt();

            while (testCases > 0) {

                testCases--;

                int length = input.nextInt();
                String sequence = input.next();

                Stack<Integer> pending = new Stack<>();
                boolean[] removed = new boolean[length + 1];

                for (int position = 0; position < length; position++) {

                    int currentIndex = position + 1;
                    char currentChar = sequence.charAt(position);

                    switch (currentChar) {

                        case '1':
                            pending.push(currentIndex);
                            break;

                        case '2':
                            if (pending.size() > 0) {
                                int idx = pending.pop();
                                removed[idx] = true;
                            } else {
                                removed[currentIndex] = true;
                            }
                            break;

                        default:
                            removed[currentIndex] = true;
                    }
                }

                ArrayList<Integer> remaining = new ArrayList<>();

                for (int i = 1; i <= length; i++) {
                    if (removed[i] == false) {
                        remaining.add(i);
                    }
                }

                System.out.println(remaining.size());

                StringBuilder output = new StringBuilder();

                for (Integer value : remaining) {
                    output.append(value).append(" ");
                }

                System.out.println(output);
            }

            input.close();
        }
    }
