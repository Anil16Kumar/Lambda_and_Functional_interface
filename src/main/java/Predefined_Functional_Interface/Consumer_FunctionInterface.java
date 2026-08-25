package Predefined_Functional_Interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_FunctionInterface {
    public static void main(String[] args) {
        Consumer<String> con=str-> System.out.println(str.substring(0,2));
        con.accept("abcdef");
        //sirf consume karta hai..

        Consumer<List<Integer>> lstConsumer1=lst->{
          for (int i:lst)
              System.out.println(i+100);
        };

        Consumer<List<Integer>> lstConsumer2=lst->{
            for (int i:lst)
                System.out.println(i);
        };

        lstConsumer1.accept(Arrays.asList(1,2,3,4,5,6));
        System.out.println("-----------");
        lstConsumer2.andThen(lstConsumer1).accept(Arrays.asList(1,2,3,4,5));
        System.out.println("-----------");
        lstConsumer1.andThen(lstConsumer2).accept(Arrays.asList(1,2,3,4,5));
    }
}
