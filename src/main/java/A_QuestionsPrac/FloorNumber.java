package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FloorNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0, t)
                .mapToObj(i -> new int[]{
                        scanner.nextInt(),
                        scanner.nextInt()
                })
                .map(arr -> arr[0] <= 2
                        ? 1
                        : ((arr[0] - 2) + arr[1] - 1) / arr[1] + 1)
                .forEach(System.out::println);
    }
}
