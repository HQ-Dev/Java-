package src.核心技术java.六_接口与内部类.接口;


import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface
 * Created by archy on 6/14/16.
 */
public class EmployeeSortTest {

    public static void main(String[] args) {
        Employee[] staffs = new Employee[3];

        staffs[0] = new Employee("Harry Hacker", 35000);
        staffs[1] = new Employee("Carl Cracker", 75000);
        staffs[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staffs);

        // print out information about all Employee object
        for (Employee e : staffs) {
            System.out.println(e.getName() + " : " + e.getSalary());
        }

    }

}
