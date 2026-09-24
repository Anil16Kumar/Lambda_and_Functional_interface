package A_Lambda_Stream_multithreading_ques_pr;

class Task implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("thread: "+i);
        }
    }
}

public class Thread2P {
    public static void main(String[] args) {
        System.out.println("main Thread");
        Task task=new Task();
        task.run();
    }
}
