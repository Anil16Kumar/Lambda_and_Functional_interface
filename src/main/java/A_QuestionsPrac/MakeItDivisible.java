package A_QuestionsPrac;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MakeItDivisible {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();

        IntStream.range(0,t)
                .mapToObj(i->scanner.nextInt())
                .map(n->n==1?"3":"3"+"0".repeat(n-2)+"3")
                .forEach(System.out::println);

       /*

       IntStream.range(0,t).forEach(i->{
            int n=scanner.nextInt();

            if(n==1){
                System.out.println("3");
            }
            else{
                String result = "3" + "0".repeat(n-2) + "3";
                System.out.println(result);
            }
        });
*/


        /*
        Function<Integer, String> function = n -> {
            if (n == 1)
                return "3";
            return "3" + "0".repeat(n - 2) + "3";
        };
        Consumer<Scanner> performTestCase = sc -> {
            int n = sc.nextInt();
            System.out.println(function.apply(n));
        };
        IntStream.range(0, scanner.nextInt())
                .forEach(i -> performTestCase.accept(scanner));
        * */
    }
}

/*
Make it Divisible
Given an integer
N
N, help Chef in finding an
N
N-digit
odd

positive

integer
odd positive integer
X
X such that
X
X is divisible by
3
3 but not by
9
9.

Note
:
Note: There should not be any leading zeroes in
X
X. In other words,
003
003 is not a valid
3
3-digit odd positive integer.

Input Format
The first line of input contains a single integer
T
T, denoting the number of testcases. The description of the
T
T testcases follows.
The first and only line of each test case contains a single integer
N
N, denoting the number of digits in
X
X.
Output Format
For each testcase, output a single line containing an
N
N-digit odd positive integer
X
X in decimal number system, such that
X
X is divisible by
3
3 but not by
9
9.

Constraints
1
≤
T
≤
500
1≤T≤500
1
≤
N
≤
10
4
1≤N≤10
4

The sum of
N
N over all test cases does not exceed
10
5
10
5

Sample 1:
Input
Output
3
1
2
3
3
15
123
Explanation:
Test Case
1
1:
3
3 is the only
1
1-digit odd positive integer which is divisible by
3
3 but not by
9
9.

Test Case
2
2:
15
15 is a
2
2-digit odd positive integer which is divisible by
3
3 but not by
9
9.
21
21 is also a valid answer, among others. Note that
03
03 is not a valid answer as there should not be any leading zeroes in the output.
* */
