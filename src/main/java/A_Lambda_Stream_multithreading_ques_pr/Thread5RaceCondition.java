package A_Lambda_Stream_multithreading_ques_pr;

class Counter{
    int count=0;
    public synchronized void increment(){
        count++;
    }
}

//Two threads increment same counter 1000 times.(Race condition) -> use of Synchronization
public class Thread5RaceCondition {
    public static void main(String[] args) throws Exception{

        Counter c1=new Counter();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++)
                c1.increment();
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++)
                c1.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        /*
        public void increment(){
            count++;
        }

        System.out.println(c1.count); -> this will give us random values.
        once we use "synchronization" keyword inside this method, we will get the required result:

        public synchronized void increment(){
            count++;
        }
        * */
        System.out.println(c1.count);

    }
}
