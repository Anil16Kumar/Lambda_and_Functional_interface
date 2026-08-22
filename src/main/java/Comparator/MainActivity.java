package Comparator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {
        List<Integer> lst= Arrays.asList(11,21,3,1,21,31,38,78,89,3);
        Collections.sort(lst,new compare());
        System.out.println(lst); // yaha par humne comparator ki class baana kar uski
        // implementation kari but hum lambda ka help se ye sab ek hi jagah par kar sakte h....

    }
}
