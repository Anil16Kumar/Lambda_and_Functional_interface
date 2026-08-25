package Predefined_Functional_Interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Supplier_FunctionalInterface {
    public static void main(String[] args) {
        //sirf return karta hai, only supply

        Supplier<String> sup=()->"abcdef";
        System.out.println(sup.get());//abcdef

        //-------------------

        Predicate<Integer> pre=num->num%2==0;
        Function<Integer,Integer> fun=num->num*num;
        Consumer<Integer> con=num-> System.out.println(num);
        Supplier<Integer> supp=()->100;

        if(pre.test(supp.get())){
            con.accept(fun.apply(supp.get()));
        }
    }
}
