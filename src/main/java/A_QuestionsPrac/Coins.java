package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t= scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->new int[]{
                        scanner.nextInt(),
                        scanner.nextInt()
                })
                .map(Arr->{
                    return Arr[0]%2==0?"YES":(Arr[1]%2==1 && Arr[0]>=Arr[1])?"YES":"NO";
                })
                .forEach(System.out::println);
    }
}
