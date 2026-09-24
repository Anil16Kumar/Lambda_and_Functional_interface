package A_Lambda_Stream_multithreading_ques_pr;

class Job extends Thread{
    public void run() {
        System.out.println("Child Thread");
    }
}
public class Thread3P {
    public static void main(String[] args) {
        Job j=new Job();
        j.start();
        System.out.println("main thread");
    }
}
