package Comparator;

import java.util.Comparator;

public class compare implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b-a;
    }
}
