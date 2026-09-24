package A_Lambda_Stream_multithreading_ques_pr;

class taskk extends Thread{
    public void run(){
        System.out.println("child");
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }
}
//Wait for child thread completion before printing "Finished".
public class Thread4Join {
    public static void main(String[] args) throws Exception{

        taskk t=new taskk();

        t.start();
        t.join();
        System.out.println("finished");

    }
}
