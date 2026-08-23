package Annonymous_inner_class_LambdaExpression;

public class MainClass {
    public static void main(String[] args) {
        Employee employee=new Employee() {
            @Override
            public String getSalary() {
                return "999";
            }

            @Override
            public String getName() {
                return "Software Engineer";
            }
        };// this is we called Anonymous inner class.

        System.out.println(employee.getSalary());
    }
}
