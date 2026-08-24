package Predefined_Functional_Interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_FunctionalInterface {
    public static void main(String[] args) {
        Predicate<Integer> pre=x->x%2==0;//function interface act as type for lambda expression
        // predicate: boolean valued function hai
        // boolean return karta h... condition check
        // aur isko .test() se call karte hai..

        System.out.println(pre.test(24));//true
        //predicate hold karta hai condition ko...

        List<Integer> lst= Arrays.asList(11,22,33,44,55,66,77,88,99);
        int sum=lst.stream().filter(x->x%2==0).mapToInt(n->n).sum();
        System.out.println(sum);

        Predicate<String> startWithA=str->str.toLowerCase().charAt(0)=='a';
        System.out.println(startWithA.test("Anil"));

        Predicate<String> endWithL=str->str.toLowerCase().charAt(str.length()-1)=='l';

        Predicate<String> combineAND=startWithA.and(endWithL);
        System.out.println(combineAND.test("Anil"));

        Predicate<String> combineOR=startWithA.or(endWithL);
        System.out.println(combineOR.test("AnilK"));

        Predicate<Object> pred=Predicate.isEqual("Anil"); // isEqual() static hai, isliye interface ke naam se call hua h
        System.out.println(pred.test("anil"));//false
        System.out.println(pred.test("Anil"));//true



    }
}
