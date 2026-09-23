package aLambdaPrac;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "', salary=" + salary + "}";
    }
}
public class StreamAndClass {
    public static void main(String[] args) {
        List<Employee> employeesList = Arrays.asList(
                new Employee(1, "Anil", "IT", 85000),
                new Employee(2, "Amit", "HR", 60000),
                new Employee(3, "Rahul", "IT", 95000),
                new Employee(4, "Ajay", "Finance", 75000),
                new Employee(5, "Rohit", "HR", 55000),
                new Employee(6, "Arun", "Finance", 90000),
                new Employee(7, "Deepa", "IT", 110000)
        );

        List<Employee> sortViaSalary = employeesList.stream()
                .sorted((emp1, emp2) -> (int) (emp1.getSalary() - emp2.getSalary()))
                .collect(Collectors.toList());
        System.out.println(sortViaSalary);
        
        /*  Optional<Employee> first = employeesList.stream()
                .sorted().findFirst();                                       */

        Employee employeeWithLowestSalary = employeesList.stream()
                .sorted((emp1,emp2)->(int)(emp1.getSalary()-emp2.getSalary()))
                .findFirst().orElse(null);
        System.out.println(employeeWithLowestSalary);

        Double averageSalary = employeesList.stream()
                .mapToInt(emp -> (int) emp.getSalary())
                .average().orElse(0); //.orElse() imp hai otherwise we need to make the variable optional
        System.out.println(averageSalary);

        List<Employee> empSalaryGreaterThan50000 = employeesList.stream()
                .filter(emp -> emp.getSalary() > 50000).collect(Collectors.toList());
        System.out.println(empSalaryGreaterThan50000);

        /*
        IT → [...]
        HR → [...]
        Finance → [...]
        * */
        Map<String, List<Employee>> groupByDepartment = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupByDepartment.forEach((dept, employees) -> {
                    System.out.println(dept+ " -> "+employees);
                });



        //Find highest-paid employee from each department.
        Map<String, Optional<Employee>> highestSalaryByGroup = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        highestSalaryByGroup.forEach((dept, emp)->{
            System.out.println(dept+" -> "+ emp);
        });



        //Count employees in each department.
        Map<String, Long> countEmpDept = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        countEmpDept.forEach((dept, count)->{
            System.out.println(dept+" -> "+count);
        });


        //Sort employees by salary descending.
        List<Employee> sortDesc = employeesList.stream()
                .sorted((emp1, emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .collect(Collectors.toList());
        System.out.println(sortDesc);


        Employee highestSalaryEmp  = employeesList.stream()
                .sorted((emp1, emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .skip(1)
                .findFirst().orElse(null);
        System.out.println(highestSalaryEmp);


        //Find employees whose name starts with A.
        List<Employee> empListNameA = employeesList.stream()
                .filter(emp -> emp.getName().charAt(0) == 'A').collect(Collectors.toList());
        System.out.println(empListNameA);
    }
}
