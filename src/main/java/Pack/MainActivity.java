package Pack;

public class MainActivity {
    public static void main(String[] args) {
        Employee employee = ()->"Anil Kumar software engineer."; // function interface act as data type for lambda expression
        System.out.println(employee.getName());
        //interface refence can be used to hold lambda expression.
        // separate class baana kar interface ko implementation karne ki koi jarurat nahi h, agar interface function interface h,
        // to sab lambda se ho jaega....

        Employee sde=()->"software engineer";
        System.out.println(sde.getName());
    }
}
