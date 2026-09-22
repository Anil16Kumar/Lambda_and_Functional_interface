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
    }
}
