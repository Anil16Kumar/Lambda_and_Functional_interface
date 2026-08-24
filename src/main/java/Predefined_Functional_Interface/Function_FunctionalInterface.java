package Predefined_Functional_Interface;

import java.util.function.Function;

public class Function_FunctionalInterface {

    public static void main(String[] args) {
        Function<String, Integer> fun=str->str.length();
        System.out.println(fun.apply("AnilKumar"));

        Function<String,String> fun2=str->str.substring(0,3);
        System.out.println(fun2.apply("AnilKumar"));
    }
}
