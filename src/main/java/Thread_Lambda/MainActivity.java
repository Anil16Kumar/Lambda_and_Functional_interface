package Thread_Lambda;

public class MainActivity {
    public static void main(String[] args) {

        SimpleClass obj = new SimpleClass();
        Thread thread = new Thread(obj);// thread ke constructor me hum pass kaete hai, implementation class,
        // implementation class kiss ki? runnable interface ki
        thread.run();
    }
}
