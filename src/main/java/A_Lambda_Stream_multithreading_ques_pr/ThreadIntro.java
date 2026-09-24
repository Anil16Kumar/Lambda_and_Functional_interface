package A_Lambda_Stream_multithreading_ques_pr;

public class ThreadIntro {
    public static void main(String[] args) {
       /*
       1. Process vs Thread:
       Process: A running application.
       Thread: A small unit of execution inside a process.

Application (Process)
 ├── Thread 1
 ├── Thread 2
 └── Thread 3

Example: A Spring Boot application is a process, and multiple requests can be handled by different threads.



2. Thread Lifecycle:
A thread generally moves through:

NEW
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
WAITING / BLOCKED / TIMED_WAITING
 ↓
TERMINATED

You can check the state:
Thread t = new Thread();
System.out.println(t.getState());


3. Creating a Thread
Method 1 — Extend Thread
class MyThread extends Thread {
    public void run() {
        System.out.println("Running");
    }
}

MyThread t = new MyThread();
t.start();
Important
t.start(); // creates a new thread
t.run();   // normal method call

4. Runnable
Usually prefer Runnable when you just want to define a task.

Runnable task = () -> {
    System.out.println("Task running");
};

Thread t = new Thread(task);
t.start();

Think:

Runnable = What should be done?
Thread   = Who executes it?



        */
    }
}
