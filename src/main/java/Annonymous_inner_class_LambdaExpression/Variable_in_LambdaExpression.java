package Annonymous_inner_class_LambdaExpression;

public class Variable_in_LambdaExpression {
    int a=23; //this is an instance variable
    private void func(){
        int b=90;
        School school = ()->{
            a=2;// we can change the instance variable(class ka normal variable) only inside the lambda expression
            // but if write (int a=4;) inside the func(), and then try to change it inside the
            //lambda expression, it will give us an error...

            int val=9; //this is a local variable

            System.out.println(val+" - "+b);
          return "Kendriya vidyalaya";
        };// function hai ye....lambda...

        School school1=new School() {

            int val=9;//this is an instance variable

            @Override
            public String getSchoolName() {
                System.out.println(this.val);
                return "Army school";
            }
        };//Anonymous inner class. This Anonymous inner class is different from Variable_in_LambdaExpression class.
    }

}
//==============================================

/*
A. Instance Variable: Declared directly inside a class, outside methods.

class Test {
    int a = 23;
}

Belongs to the object.
Can be changed.
Does not need to be final.
Can be accessed and modified inside a lambda.
int a = 23;

Runnable r = () -> {
    a = 10;   // ✅ allowed
};


B. Local Variable: Declared inside a method/block.

void func() {
    int x = 10;
}
Belongs to the method/block.
Normally, it can be changed:
int x = 10;
x = 20;       // ✅ allowed
But if a lambda captures/uses it, it must be final or effectively final.
int x = 10;

Runnable r = () -> {
    System.out.println(x);   // ✅ allowed
};

But:

int x = 10;

Runnable r = () -> {
    x = 20;                  // ❌ ERROR
};

--------------------------------------------------------

What is "Effectively Final"?
A local variable is effectively final when you don't write final, but you never change its value.

int x = 10;
Runnable r = () -> {
    System.out.println(x);
};

x is effectively final because its value is never changed.

Same idea as:
final int x = 10;

So remember:
A local variable used inside a lambda must be final or effectively final.
---------------------------------------
Lambda Expression: A lambda is a short way of implementing a functional interface.

Suppose:

interface School {
    String getSchoolName();
}

Lambda:
School school = () -> {
    return "Kendriya Vidyalaya";
};

Instead of writing:
School school = new School() {
    @Override
    public String getSchoolName() {
        return "Kendriya Vidyalaya";
    }
};

Lambda can:
Access instance variables.
Modify instance variables.
Access final/effectively-final local variables.
Have its own local variables.

Example:
int a = 23;       // instance variable
School school = () -> {
    a = 2;        // ✅ instance variable can change
    int val = 9;  // ✅ local variable of lambda
    System.out.println(val);
    return "Kendriya Vidyalaya";
};

4. Anonymous Inner Class: An anonymous inner class is a class created without giving the class a name.

School school = new School() {
    int val = 9;
    @Override
    public String getSchoolName() {
        System.out.println(this.val);
        return "Army School";
    }
};

Here:

int val = 9; is an instance variable of the anonymous inner class.

So it is different from:

int val = 9;
inside the lambda.

5. this — Very Important
In Lambda: Lambda does not create its own this.

class Test {

    int a = 10;

    void func() {
        Runnable r = () -> {
            System.out.println(this.a);
        };
    }
}

Here:

this: refers to the outer/enclosing Test object.

So:
this.a
means: a belonging to the Test object.

In Anonymous Inner Class: Anonymous inner class has its own this.

Runnable r = new Runnable() {

    int a = 20;

    @Override
    public void run() {
        System.out.println(this.a);
    }
};

Here:
this: refers to the anonymous inner class object.

Therefore:
this.a
means the anonymous class's a.

6. Lambda vs Anonymous Inner Class
    | Feature                              | Lambda                          | Anonymous Inner Class           |
| ------------------------------------ | ------------------------------- | ------------------------------- |
| Syntax                               | `() -> {}`                      | `new Interface() {}`            |
| Used with functional interface       | ✅                               | ✅                               |
| Has its own `this`                   | ❌                               | ✅                               |
| `this` refers to                     | Outer object                    | Anonymous class object          |
| Can access instance variables        | ✅                               | ✅                               |
| Can modify instance variables        | ✅                               | ✅                               |
| Can have its own instance variables  | ❌                               | ✅                               |
| Local variable captured from outside | Must be final/effectively final | Must be final/effectively final |
| Can have local variables inside body | ✅                               | ✅                               |


7. Three Different Variables to Remember

Consider:

class Test {

    int a = 23;                  // ① Instance variable

    void func() {

        int x = 10;              // ② Local variable

        Runnable r = () -> {

            int y = 20;          // ③ Lambda's local variable

            a = 30;              // ✅ allowed
            System.out.println(x);// ✅ allowed if effectively final

        };
    }
}
① a
int a = 23;
→ Instance variable of Test
→ Can be changed inside lambda.

② x
int x = 10;
→ Local variable of func()
→ If used inside lambda, must be final/effectively final.

③ y
int y = 20;
→ Local variable of lambda
→ Can be changed.

class Variable_in_LambdaExpression {

    int a = 23;                         // Instance variable

    void func() {

        School school = () -> {

            a = 2;                      // ✅ Can modify instance variable

            int val = 9;                // Lambda's local variable

            System.out.println(val);

            return "Kendriya Vidyalaya";
        };


        School school1 = new School() {

            int val = 9;                // Anonymous class's instance variable

            @Override
            public String getSchoolName() {

                System.out.println(this.val);
                // this → anonymous inner class object

                return "Army School";
            }
        };
    }
}


Rule 1
Instance variables can be modified inside a lambda.
int a = 10;
a = 20;       // ✅

Rule 2
Local variables used/captured by a lambda must be final or effectively final.
int x = 10;
() -> System.out.println(x);  // ✅

But:
() -> x = 20;                 // ❌

Rule 3
A local variable inside the lambda itself can be modified.
() -> {
    int x = 10;
    x = 20;                   // ✅
}

Rule 4
Lambda does not have its own this.
this → outer object

Rule 5
Anonymous inner class has its own this.
this → anonymous class object

Rule 6
val inside a lambda and val inside an anonymous class are different variables.

Lambda:
int val = 9;
→ lambda-local variable

Anonymous class:
int val = 9;
→ anonymous class instance variable
One-line memory trick

Lambda can change outer object's instance variables, but a captured local variable must be final/effectively final;
lambda shares this, while anonymous class gets its own this.

* */