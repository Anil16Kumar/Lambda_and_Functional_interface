//package AAQuestionsPracCFCC;

import java.util.Scanner;

public class ANDORSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            String binaryString=scanner.next();
            int totalOnes = 0;
            int totalZeros = 0;

            for (char ch : binaryString.toCharArray()) {
                if (ch == '1')
                    totalOnes++;
                else
                    totalZeros++;
            }

            if (binaryString.charAt(0) == '1') {
                System.out.println(totalZeros);
                continue;
            }

            int onesBefore = 0;
            int zerosBefore = 0;

            int answer = totalOnes;

            for (int i = 0; i < n; i++) {

                char ch = binaryString.charAt(i);

                if (ch == '1') {

                    int zerosAfter = totalZeros - zerosBefore;
                    int operations = onesBefore + zerosAfter;

                    answer = Math.min(answer, operations);

                    onesBefore++;

                } else {
                    zerosBefore++;
                }
            }
            System.out.println(answer);
        }
    }
}
