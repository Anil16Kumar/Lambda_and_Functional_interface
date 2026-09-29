package A_Lambda_Stream_multithreading_ques_pr;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class Staff {
    int id;
    String name;
    String department;
    double salary;

    public Staff(int id, String name, String department, double salary) {
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

public class StreamClassObjectQuestions {
    public static void main(String[] args) {
        List<Staff> StaffList= Arrays.asList(
                new Staff(1, "Anil", "IT", 85000),
                new Staff(2, "Amit", "HR", 60000),
                new Staff(3, "Rahul", "IT", 95000),
                new Staff(5, "Rohit", "HR", 55000),
                new Staff(6, "Arun", "Finance", 90000),
                new Staff(4, "Ajay", "Finance", 75000),
                new Staff(7, "Deepa", "IT", 110000)
        );

        // q. Department → List of Employee Names
        /*
        {
IT=[Anil, Rahul, Deepa],
HR=[Amit, Rohit],
Finance=[Ajay, Arun]
}
        * */
        Map<String, List<Staff>> grpInMap = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment));
        // this will give me map group by department

        Map<String, List<String>> answerMapNameDepartmentList = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                Collectors.mapping(Staff::getName, Collectors.toList())));
        System.out.println(answerMapNameDepartmentList);

        //=========================================================

        /*
        Department → Total Salary

{
IT=290000,
HR=115000,
Finance=165000
}
        *
        * */
        Map<String, List<Double>> salaryListByDepertment = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                Collectors.mapping(Staff::getSalary, Collectors.toList())));
        // above will give us :
//        {Finance=[90000.0, 75000.0], HR=[60000.0, 55000.0], IT=[85000.0, 95000.0, 110000.0]}
        // but we want sum off all these:
        Map<String, Double> salarySumByDepartment = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                                Collectors.summingDouble(Staff::getSalary)));
        System.out.println(salarySumByDepartment);


        //=========================================================================

        /*
        Department → Average Salary

{
IT=96666.67,
HR=57500,
Finance=82500
}
        * */
        Map<String, Double> averageSalaryByDepartment = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                Collectors.averagingDouble(Staff::getSalary)));
        System.out.println(averageSalaryByDepartment);

        //======================================================================

        /*
        Department → Number of Employees

{
IT=3,
HR=2,
Finance=2
}
        * */

        Map<String, Long> countStaffInsideDepartment = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                Collectors.counting()));
        System.out.println(countStaffInsideDepartment);

        //=================================================================

        /*
        Department → Highest Paid Employee

{
IT=Deepa,
HR=Amit,
Finance=Arun
}
        * */

        Map<String, Optional<Staff>> highestPaid = StaffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Staff::getSalary))));
        System.out.println(highestPaid);

    }
}
