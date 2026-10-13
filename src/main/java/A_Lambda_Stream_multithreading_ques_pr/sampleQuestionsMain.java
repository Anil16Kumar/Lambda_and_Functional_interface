package A_Lambda_Stream_multithreading_ques_pr;

import jdk.jfr.Frequency;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
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

public class sampleQuestionsMain {
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

        //----------------------------------------------------------------------------------------------------

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //sum all odd;
        int oddSumFromList = numberList.stream().filter(val -> val % 2 == 1)
                .mapToInt(num -> num).sum();
        System.out.println(oddSumFromList);

        //1st even
        OptionalInt firstEven = numberList.stream().filter(num -> num % 2 == 0)
                .mapToInt(num->num).findFirst();
        System.out.println(firstEven);

        //---
        List<Integer> numArrayList = Arrays.asList(10,5,20,8,15,30,30,5,10);

        //2nd largest
        Optional<Integer> secondLargest = numArrayList.stream().distinct()
                .sorted((a, b) -> b - a).skip(1).findFirst();
        System.out.println(secondLargest);

        //3rd largest
        Optional<Integer> thirdLargest = numArrayList.stream().distinct()
                .sorted((a, b) -> (b - a)).skip(2).findFirst();
        System.out.println(thirdLargest);

        //Find highest unique value
        Set<Map.Entry<Integer, Long>> entries = numArrayList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();

        Optional<Integer> maxValue = entries.stream()
                .filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).max(Integer::compareTo);
        System.out.println(entries);

         System.out.println(maxValue);

         //Remove duplicates and sort
        List<Integer> sortedList = numArrayList.stream().distinct().sorted().toList();
        System.out.println(sortedList);

//        Count numbers greater than 10
        long countGreaterThan10 = numArrayList.stream().distinct().filter(num -> num > 10).count();
        System.out.println(countGreaterThan10);

        //Get top 3 largest numbers
        List<Integer> top3max = numArrayList.stream().distinct()
                .sorted((a, b) -> (b - a)).limit(3).toList();
        System.out.println(top3max);

//        Get bottom 3 smallest numbers
        List<Integer> bottomThree = numArrayList.stream().sorted().limit(3).toList();
        System.out.println(bottomThree);

//        Check if all numbers are even
        boolean isAllEven = numArrayList.stream().allMatch(num -> num % 2 == 0);
        System.out.println(isAllEven);

//        Check if any number is divisible by 7
        boolean sevenDivision = numArrayList.stream().anyMatch(num -> num % 7 == 0);
        System.out.println(sevenDivision);

        //Check if no number is negative
        boolean negative = numArrayList.stream().noneMatch(num -> num < 0);
        System.out.println(negative);

        List<String> namesList = Arrays.asList("Anil","Amit","Rahul","Ajay","Rohit","Arun", "Xu", "Lee");

//        Names starting with A
        List<String> namesWithA = namesList.stream().filter(str -> str.charAt(0) == 'A')
                .collect(Collectors.toList());
        System.out.println(namesWithA);

        //Names ending with t
        List<String> nameendsT = namesList.stream().filter(str -> str.charAt(str.length() - 1) == 't')
                .collect(Collectors.toList());
        System.out.println(nameendsT);

        //Convert names to lowercase
        List<String> lowerName = namesList.stream().map(str->str.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowerName);



        List<String> descSort = namesList.stream().sorted((s1, s2) -> (s2.length() - s1.length()))
                .collect(Collectors.toList());
        System.out.println(descSort);
        // longest name
        String longestName = namesList.stream()
                .max((s1, s2) ->Integer.compare(s1.length(), s2.length()))
                .orElse("");
        System.out.println(longestName);

        //short name
        String shortName = namesList.stream()
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse("");
        System.out.println(shortName);

        //Sort by length
        List<String> lengthSorted = namesList.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        System.out.println(lengthSorted);

//        Count names having length > 4
        long lengthGreaterThan4 = namesList.stream().filter(str -> str.length() > 4).count();
        System.out.println(lengthGreaterThan4);

        //Find first name starting with R
        String startWithR = namesList.stream().filter(str -> str.startsWith("R")).findFirst().orElse("-1");
        System.out.println(startWithR);

        //join all name with "-"
        String joiningWithDash = namesList.stream().collect(Collectors.joining("-"));
        System.out.println(joiningWithDash);

        List<String> wordsList = Arrays.asList("java","spring","boot","java","microservice");

        //duplicate words
        Map<String, Long> freqOfAll = wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqOfAll);

        Set<Map.Entry<String, Long>> entries1 = wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
        System.out.println(entries1);

        List<String> duplicateValues = entries1.stream()
                .filter(val -> val.getValue() == 2)
                .map(Map.Entry::getKey).toList();
        System.out.println(duplicateValues);

        //Find unique words only
        List<String> uniqueElements = wordsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(val -> val.getValue() == 1)
                .map(Map.Entry::getKey).toList();
        System.out.println(uniqueElements);



    }
}
