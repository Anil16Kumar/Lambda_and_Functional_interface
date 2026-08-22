package Comparator;

import java.util.*;

class Student{

    public Integer id;
    public String name;

    public Student(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class MainActivity_Lambda {
    public static void main(String[] args) {
        List<Integer> lst= Arrays.asList(11,21,3,1,21,31,38,78,89,3,23,1,87,99);
        Collections.sort(lst,(a,b)->b-a);// hume yaha Collections.sort(lst,new compare()); aise likhane ki
        // koi jarurat nahi hai, we can use lambda for all this, kyuki Comparator ke ander ek hi abstract method hai...
        System.out.println(lst);

        System.out.println("========================");

        Set<Integer> s1=new TreeSet<>();
        s1.add(12);
        s1.add(10);
        s1.add(15);
        System.out.println("Before manual sorting: "+s1);
        Set<Integer> s2=new TreeSet<>((a,b)->b-a);
        s2.add(12);
        s2.add(10);
        s2.add(15);
        System.out.println("After manual sorting desc : "+s2);

        System.out.println("========================");

        Map<Integer, String> mp1=new TreeMap<>();
        mp1.put(12,"apple");
        mp1.put(10,"orange");
        mp1.put(15,"mango");
        System.out.println("Before manual sorting: "+mp1);
        Map<Integer, String> mp2=new TreeMap<>((a,b)->b-a);
        mp2.put(12,"apple");
        mp2.put(10,"orange");
        mp2.put(15,"mango");
        System.out.println("After manual sorting desc : "+mp2);

        System.out.println("========================");

        Student st1=new Student(23,"Atul Singh");
        Student st2=new Student(3, "Jeetu Kumar");
        Student st3=new Student(45, "Alice Bob");
        List<Student> lst2=new ArrayList<Student>();
        lst2.add(st1);
        lst2.add(st2);
        lst2.add(st3);
        Collections.sort(lst2, (a,b)-> b.id - a.id);// iss baar to hume ye (a,b)-> b.id - a.id likhana hi padega
        // kyuki collection ko nahi pata hi custome class ko kaise sort karte hai, hume mention karna hi padega...specially in case of
        // custom class(non primitive data types )
        System.out.println(lst2);



    }
}
