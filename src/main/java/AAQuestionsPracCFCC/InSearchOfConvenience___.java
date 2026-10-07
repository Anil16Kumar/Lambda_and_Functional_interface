//package AAQuestionsPracCFCC;

import java.util.Scanner;

public class InSearchOfConvenience___ {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int testCases = sc.nextInt();

            for (int i = 0; i < testCases; i++) {

                int xCoordinate = sc.nextInt();
                int yCoordinate = sc.nextInt();
                int radius = sc.nextInt();

                int newX = xCoordinate + radius;

                String result = newX + " " + yCoordinate;

                System.out.println(result);
            }

            sc.close();
        }
    }