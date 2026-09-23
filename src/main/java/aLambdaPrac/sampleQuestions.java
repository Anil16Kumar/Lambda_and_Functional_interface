package aLambdaPrac;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Calculator{
    public int calculate(int a, int b);
}

@FunctionalInterface
interface StringProcessor {
    String process(String s);
}

public class sampleQuestions {
    public static void main(String[] args) {

        StringProcessor lowerCase=(str)->str.toLowerCase();
        StringProcessor upperCase=(str)->str.toUpperCase();
        System.out.println(lowerCase.process("asdIUDDSIDSDH")+"  "+upperCase.process("hjhaDSUyakAJ"));

        Calculator addition=(a,b)->a+b;
        Calculator substraction=(a,b)->a-b;
        Calculator multiplication=(a,b)->a*b;
        Calculator division=(a,b)->a/b;

        System.out.println(addition.calculate(3,4)+" "+substraction.calculate(3,4));


        int[] Arr={1,2,3,4,5,6,7,8,9,10};
        List<Integer> collect = Arrays.stream(Arr).map(val -> val * 2).boxed().collect(Collectors.toList());
        System.out.println(collect);

        Function<Integer, Integer> fun=(num)->num*num;
        System.out.println(fun.apply(3));

        Consumer<String> con=name->System.out.println("Hi, "+name);
        con.accept("Anil");

        //-- Stream Practice

        List<Integer> nums = Arrays.asList(10, 5, 20, 8, 15, 30, 5, 10);
        List<Integer> evenList = nums.stream().filter(val -> val % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList);

        List<Integer> numbersGreaterThan10 = nums.stream().filter(val -> val > 10).collect(Collectors.toList());
        System.out.println(numbersGreaterThan10);

        List<Integer> maximumValue = nums.stream()
                .sorted((a,b)->b-a)
                .limit(1).collect(Collectors.toList());
        System.out.println(maximumValue);

        List<Integer> minimumValue = nums.stream().sorted().limit(1).collect(Collectors.toList());
        System.out.println(minimumValue);

        List<Integer> onlyUnique = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(onlyUnique);

        int totalSum = nums.stream().mapToInt(num -> num).sum();
        System.out.println(totalSum);

        OptionalDouble average = nums.stream().mapToInt(num -> num).average();
        System.out.println(average);

        long valuesGreaterThan10 = nums.stream().filter(num -> num > 10).count();
        System.out.println(valuesGreaterThan10);

        List<Integer> secondLargestValue = nums.stream()
                .sorted((a, b) -> (b - a))
                .skip(1).limit(1)
                .collect(Collectors.toList());
        System.out.println(secondLargestValue);

        List<Integer> firstValueGreaterThan15 = nums.stream()
                .filter(val -> val > 15)
                .sorted()
                .limit(1).collect(Collectors.toList());
        System.out.println(firstValueGreaterThan15);

        //---------

        List<String> stringList = Arrays.asList("Anil", "Amit", "Rahul", "Ajay", "Rohit", "Arun");

        List<String> nameStartsWithA = stringList.stream()
                .filter(str -> str.charAt(0) == 'A')
                .collect(Collectors.toList());
        System.out.println(nameStartsWithA);

        List<String>  nameLengthGreaterThan4 = stringList.stream()
                .filter(str -> str.length() > 4)
                .collect(Collectors.toList());
        System.out.println(nameLengthGreaterThan4);

        List<String> stringToUpperCase = stringList.stream()
                .map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(stringToUpperCase);

        List<String> sortAlphabetical = stringList.stream()
                .sorted().collect(Collectors.toList());
        System.out.println(sortAlphabetical);

        String longestString = stringList.stream()
                .sorted((a, b) -> (b.length() - a.length()))
                .findFirst().orElse("");
        System.out.println(longestString);

        long countStringStartWithA = stringList.stream()
                .filter(str -> str.charAt(0) == 'A').count();
        System.out.println(countStringStartWithA);

        String stringJoinCom = stringList.stream().collect(Collectors.joining(","));
        System.out.println(stringJoinCom);
    }
}
