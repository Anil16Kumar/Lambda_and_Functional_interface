package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DistinctPairSums {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->new int[]{
                        scanner.nextInt(),
                        scanner.nextInt()
                })
                .map(Arr-> Arr[0]==Arr[1]? 1 : (Arr[1]-Arr[0])*2 + 1)
                .forEach(System.out::println);
    }
}
