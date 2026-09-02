package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CodeforcesChecking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->scanner.next())
                .map(str->{
                    char ch=str.charAt(0);
                    return  "codeforces".contains(String.valueOf(ch))?"YES":"NO";
                })
                .forEach(System.out::println);
    }
}
