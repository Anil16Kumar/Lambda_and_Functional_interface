package A_Lambda_Stream_multithreading_ques_pr;

class MyThread extends Thread{

    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("thread "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

public class Thread1P {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();
    }
}
