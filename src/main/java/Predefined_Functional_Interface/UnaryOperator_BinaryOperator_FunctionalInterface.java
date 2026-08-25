package Predefined_Functional_Interface;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperator_BinaryOperator_FunctionalInterface {
    public static void main(String[] args) {
        Function<Integer,Integer> fun=x->x*x;
        Function<String,String> fun1=str->str.toLowerCase();
        // agar function ke aandar, jo input ka type hai, wahi output ka type hai,
        // tab hum use karte hai UnaryOperator, as follow

        UnaryOperator<Integer> uop=x->x*x; // same as: Function<Integer,Integer> fun=x->x*x;
        UnaryOperator<String> uop2=str->str.toLowerCase();

        System.out.println(uop.apply(5)+"  -  "+fun.apply(5));
        System.out.println(uop2.apply("abAS")+"  -  "+fun1.apply("abAS"));

        //-----------------

        BiFunction<String,String,String> biFun=(s1,s2)->s1+s2;

        BinaryOperator<String> biOpe=(s1,s2)->s1+s2;

        System.out.println(biOpe.apply("abc","xyz")+"  -  "+biFun.apply("abc","xyz"));

    }
}
