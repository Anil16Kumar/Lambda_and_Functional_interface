
interface A{
    default void sayHello(){
        System.out.println("A hello");
    }
}
interface B{
    default void sayHello(){
        System.out.println("B Hello");
    }
}

public class MyClass_default implements A,B{
    public static void main(String[] args) {
        MyClass_default myClass1=new MyClass_default();
        myClass1.sayHello();
    }

    @Override
    public void sayHello() {
        A.super.sayHello();
    }
}
