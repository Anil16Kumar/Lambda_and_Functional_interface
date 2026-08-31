package A_QuestionsPrac;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MinimumNumberOfPizzas {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->new int[]{
                        scanner.nextInt(),
                        scanner.nextInt()
                })
                .map(arr->{
                    int gcd=BigInteger.valueOf(arr[0]).gcd(BigInteger.valueOf(arr[1])).intValue();
                    return arr[0]/gcd;
                })
                .forEach(System.out::println);
/*
        Consumer<Scanner> performTestCases=scanner1 -> {
            int num=scanner1.nextInt();
            int num1=scanner1.nextInt();
            System.out.println((num*num1)/BigInteger.valueOf(num).gcd(BigInteger.valueOf(num1)).intValue()/num1);
        };

        IntStream.range(0,t)
                .forEach(i-> performTestCases.accept(scanner));

                */

    }
}
