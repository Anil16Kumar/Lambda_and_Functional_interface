
interface a{
    public static void sayHello(){
        System.out.println("A hello");
    }
    default void sayBye(){
        System.out.println("A bye.");
    }
}

public class Static_Method implements a{
    public static void main(String[] args) {
        Static_Method obj=new Static_Method();
//        obj.sayHello(); -> error dega...
        a.sayHello();// only way to call static methods of interface, using there interface name....but we can call default methods
        // static method interface ka, implementation class ko static method dekhata hi nahi hai...isliye hum interface ke naam se static
        // method ko access karte hai...
        obj.sayBye();

    }
}
