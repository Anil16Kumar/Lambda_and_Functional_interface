package Predefined_Functional_Interface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicate_BiFunction_BiConsumer {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> bpre=(num1,num2)->num2%2==0 && num1%2==0;
        System.out.println(bpre.test(2,4));

        BiPredicate<String, Integer> bpre2=(Str,num)->Str.length()==num;
        System.out.println(bpre2.test("abcde",5));

        BiFunction<String, String, Integer> bfun=(str1,str2)->str1.length()+str2.length();
        System.out.println(bfun.apply("abcde","xyz"));

        BiConsumer<String, String> bcum=(s1,s2)-> System.out.println(s1+"-"+s2);
                bcum.accept("asdf","asdad");
    }
}
