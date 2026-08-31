//package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->scanner.next())
                .map(str->{
                    long cnt=str.chars().filter(c->c=='1').count();
                    return Math.min(cnt,str.length()-cnt)%2==1?"DA":"NET";
                })
                .forEach(System.out::println);


    }
}
