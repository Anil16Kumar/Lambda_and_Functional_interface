
interface Parent{
    default void sayHello(){
        System.out.println("hello...");
    }
}
class child implements Parent{
}

public class Default_Method {
    public static void main(String[] args) {
        child ch=new child();
        ch.sayHello();
    }
}
