//package AAQuestionsPracCFCC;

import java.util.Scanner;

public class ThrePiles {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long t=scanner.nextInt();
        while(t-->0){
            long  a=scanner.nextLong();
            long b=scanner.nextLong();
            long c=scanner.nextLong();

            long way1=Math.abs(a-b);
            long way2=Math.abs(a-b+c);
            System.out.println(Math.max(way2, way1));
        }
    }
}
