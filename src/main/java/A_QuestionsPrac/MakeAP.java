package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MakeAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->new int[]{
                        scanner.nextInt(),
                        scanner.nextInt(),
                        scanner.nextInt()
                })
                .map(Arr->{
                    boolean firstNumber=first(Arr[0], Arr[1], Arr[2]);
                    boolean secondNumber=second(Arr[0], Arr[1], Arr[2]);
                    boolean thirdNumber=third(Arr[0], Arr[1], Arr[2]);

                    return firstNumber || secondNumber || thirdNumber ? "YES" : "NO";

                })
                .forEach(System.out::println);
    }
    public static boolean first(int a, int b, int c){
        int numerator = 2*b - c;
        return numerator > 0 && numerator % a == 0;
    }

    public static boolean second(int a, int b, int c){
        int numerator = a + c;
        return numerator % (2*b) == 0 && numerator / (2*b) > 0;
    }

    public static boolean third(int a, int b, int c){
        int numerator = 2*b - a;
        return numerator > 0 && numerator % c == 0;
    }


}
