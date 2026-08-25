package Predefined_Functional_Interface;

public class Method_and_Constructor_References {
    public static void main(String[] args) {
        //method Reference:
        //1. method ko refer karta hai
        //2. we can use this as place of lambda expression

        /*
        Method Reference:
A method reference is a shorthand for a lambda expression when the lambda only calls an existing method.

Lambda
name -> System.out.println(name)
Method reference
System.out::println

The :: operator is called the method reference operator.

Basic syntax
ClassName::methodName
or
object::methodName

Types of Method References
There are 4 types.

1. Static method reference
ClassName::staticMethod

Example:
class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}

Lambda:
BiFunction<Integer, Integer, Integer> f = (a, b) -> Calculator.add(a, b);

Method reference:
BiFunction<Integer, Integer, Integer> f = Calculator::add;

2. Instance method of a particular object
object::instanceMethod

Example:
class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
Printer printer = new Printer();

Consumer<String> consumer = message -> printer.print(message);

Can be written as:
Consumer<String> consumer = printer::print;

3. Instance method of an arbitrary object of a class

Syntax:
ClassName::instanceMethod

Example:
List<String> names = Arrays.asList("Anil", "Rahul", "Amit");

Lambda:
names.sort((a, b) -> a.compareToIgnoreCase(b));

Method reference:
names.sort(String::compareToIgnoreCase);

Here, the first argument becomes the object on which the method is called.

Conceptually:
(a, b) -> a.compareToIgnoreCase(b)

becomes:
String::compareToIgnoreCase

4. Constructor reference
Constructor references use:
ClassName::new

Example:
class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
}

Lambda:
Function<String, Employee> function = name -> new Employee(name);

Constructor reference:
Function<String, Employee> function = Employee::new;

So:
name -> new Employee(name)

becomes:
Employee::new

3. Constructor Reference with No Arguments

Suppose:
class Employee {
    public Employee() {
        System.out.println("Employee created");
    }
}

Lambda:
Supplier<Employee> supplier = () -> new Employee();

Constructor reference:
Supplier<Employee> supplier = Employee::new;

Then:
Employee emp = supplier.get();


4. Constructor Reference with Multiple Arguments
class Employee {
    private String name;
    private int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

We can use:
BiFunction<String, Integer, Employee> function = Employee::new;

This is equivalent to:
BiFunction<String, Integer, Employee> function = (name, age) -> new Employee(name, age);

5. Method Reference with Streams
This is one of the most common interview/use cases.

Suppose:
List<String> names =  Arrays.asList("Anil", "Rahul", "Amit");

Using lambda:
names.forEach(name -> System.out.println(name));

Using method reference:
names.forEach(System.out::println);

Another example:
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);

Equivalent lambda:
names.stream()
     .map(name -> name.toUpperCase())
     .forEach(name -> System.out.println(name));

| Lambda                       | Method Reference      |
| ---------------------------- | --------------------- |
| `x -> System.out.println(x)` | `System.out::println` |
| `x -> x.toUpperCase()`       | `String::toUpperCase` |
| `x -> Integer.parseInt(x)`   | `Integer::parseInt`   |
| `x -> new Employee(x)`       | `Employee::new`       |


        * */
    }
}
