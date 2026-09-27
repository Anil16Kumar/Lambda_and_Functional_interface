package A_Lambda_Stream_multithreading_ques_pr;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestionsP {
    public static void main(String[] args) {

        //square
        List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> squareOfNumber = nums.stream()
                .map(val -> val * val).collect(Collectors.toList());
        System.out.println(squareOfNumber);

        //divisible by 3
        List<Integer> numList = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> divisibleBy3 = numList.stream()
                .filter(val -> val % 3 == 0).collect(Collectors.toList());
        System.out.println(divisibleBy3);

        //Sum of odd numbers
        List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int oddSum = lst.stream().filter(val -> val % 2 == 1)
                .mapToInt(val -> val).sum();
        System.out.println(oddSum);

        //Find numbers between 10 and 30
        List<Integer> betweenNumsList = Arrays.asList(5, 12, 18, 25, 31, 40, 15);
        List<Integer> inBetween = betweenNumsList.stream()
                .filter(num -> num >= 10 && num <= 30).collect(Collectors.toList());
        System.out.println(inBetween);

        //remove dublicate
        List<String> names = Arrays.asList("Anil", "Amit", "Anil", "Rahul", "Amit", "Rohit");
        List<String> distinctName = names.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctName);

        //Double only even numbers
        List<Integer> dList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> doubleEven = dList.stream().filter(num -> num % 2 == 0).map(num -> num * 2).collect(Collectors.toList());
        System.out.println(doubleEven);

        //Convert names to uppercase if length > 4
        List<String> nameList = Arrays.asList("Anil", "Rahul", "Amit", "Rohit", "Raj");
        List<String> lengthGreater = nameList.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
        System.out.println(lengthGreater);
    }
}
