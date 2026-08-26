package A_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prac1 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        List<Integer> collect = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);//[2, 4, 6, 8, 0]

        List<Integer> collect1 = collect.stream().map(x -> x / 2).collect(Collectors.toList());
        System.out.println(collect1);//[1, 2, 3, 4, 0]

        // we can even combine them:
        List<Integer> combined = list.stream().filter(num -> num % 2 == 0).map(x -> x / 2).collect(Collectors.toList());
        System.out.println(combined);//[1, 2, 3, 4, 0]




        List<Integer> randomNum=Arrays.asList(12,2,12,45,23,57,8,45,8,0,34,34,100,50,45,50);

        //for unique elements..
        List<Integer> collect2 = randomNum.stream().filter(num -> num % 2 == 0)
                .map(num -> num / 2).distinct()// for unique elements we use distinct()
                .collect(Collectors.toList());
        System.out.println(collect2);

        //sorted:
        List<Integer> collect3 = randomNum.stream().filter(num -> num % 2 == 0)
                .map(num -> num / 2)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect3);

        // sorted in reversed order
        List<Integer> collect4 = randomNum.stream().filter(num -> num % 2 == 0)
                .map(num -> num / 2)
                .distinct()
                .sorted((a,b)->b-a)
                .collect(Collectors.toList());
        System.out.println(collect4);

        //we can even put limit, how much we want.. 3 biggest number:
        List<Integer> collect5 = randomNum.stream().filter(num -> num % 2 == 0)
                .map(num -> num / 2)
                .distinct()
                .sorted((a,b)->b-a)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect5);//[50, 25, 17]

        //we can even skip few elements...let say 50, 25, 17 remove 50 from this list..
        List<Integer> collect6 = randomNum.stream().filter(num -> num % 2 == 0)
                .map(num -> num / 2)
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(collect6);//[25, 17]
        // limit: start ke kitne elements chahiye
        // skip: starting ke kitne elements nahi chahiye


        List<Integer> collect7 = Stream.iterate(0, n -> n + 1)
                .limit(101)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(collect7);

        List<Integer> collect8 = Stream.iterate(0, n -> n + 1)
                .limit(101)
                .skip(1)
                .filter(num->num%2==0)
                .map(num->num/10)
                .distinct()
                .sorted()
                .peek(x-> System.out.println(x))
                .collect(Collectors.toList());
        System.out.println(collect8);



        Integer i = Stream.iterate(0, n -> n + 1)
                .limit(101)
                .map(num -> num / 20)
                .distinct()
                .peek(System.out::println)
                .max((a, b) -> a - b)
                .get();
        System.out.println(i);


        long count = Stream.iterate(0, num -> num + 1)
                .limit(101)
                .map(num -> num / 10)
                .distinct()
                .count();
        System.out.println(count);//11


    }
}
