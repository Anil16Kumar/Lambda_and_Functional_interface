package A_QuestionsPrac;

import java.util.Scanner;
//import java.util.stream.IntStream;

public class GoodContest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            int[] arr=new int[3];
            for(int i=0;i<3;i++)
                arr[i]=scanner.nextInt();

            System.out.println(n - Math.min(arr[0],Math.min(arr[1],arr[2])));
        }
    }
}
