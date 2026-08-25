package Predefined_Functional_Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Function_FunctionalInterface {

    private static class Student{
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Function<String, Integer> fun=str->str.length();
        System.out.println(fun.apply("AnilKumar"));

        Function<String,String> fun2=str->str.substring(0,3);
        System.out.println(fun2.apply("AnilKumar"));

        Function<String,String> fun3=str->str.substring(0,1);
        System.out.println(fun3.apply("AnilKumarSingh"));

        // Function<> perform some task, apply() se call karte hai..
//        Function<1st, 2nd> 1st = input argument data type., 2nd = return type...

        Function<List<Student>, List<Student>> studentsStartsWithA=lst->{
            List<Student> answer=new ArrayList<>(            );
          for(Student stu:lst){
            if(fun3.apply(stu.getName()).equalsIgnoreCase("A"))
                answer.add(stu);
          }
          return answer;
        };

        Student s1=new Student(1,"Anil");
        Student s2=new Student(2,"Anurag");
        Student s3=new Student(3,"Raju");
        Student s4=new Student(4,"Rahul");
        Student s5=new Student(5,"Anu");


        List<Student> list= Arrays.asList(s1,s2,s3,s4,s5);
        System.out.println(studentsStartsWithA.apply(list));

        // function chaining

        Function<String,String> f1=str->str.toUpperCase();
        Function<String,String> f2=str->str.substring(0,4);

        Function<String,String> funcChain=f1.andThen(f2);
        System.out.println(funcChain.apply("abcdefghi"));

        //  -or-

        System.out.println(f1.andThen(f2).apply("xyzpqrstuv"));

        Function<Integer,Integer> func1=x->x*2;
        Function<Integer,Integer> func2=x->x*x*x;
        System.out.println(func1.andThen(func2).apply(3));//216
        System.out.println(func2.andThen(func1).apply(3));//54

        System.out.println(func1.compose(func2).apply(3));//54

        Function<String,String> IdFunction=Function.identity();
        System.out.println(IdFunction.apply("abcdefghijklmn"));



    }
}
