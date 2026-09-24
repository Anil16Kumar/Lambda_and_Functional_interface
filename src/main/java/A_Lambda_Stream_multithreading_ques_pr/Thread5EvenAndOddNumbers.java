package A_Lambda_Stream_multithreading_ques_pr;

/*
Odd : 1
Even : 2
Odd : 3
Even : 4
* */
public class Thread5EvenAndOddNumbers {
    public static void main(String[] args) {
        Thread odd = new Thread(() -> {
            for(int i=1;i<=10;i+=2) {
                System.out.println("Odd : " + i);
            }
        });

        Thread even = new Thread(() -> {
            for(int i=2;i<=10;i+=2) {
                System.out.println("Even : " + i);
            }
        });

        odd.start();
        even.start();
    }
}
