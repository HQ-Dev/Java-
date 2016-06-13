package src.核心技术java.六_接口与内部类.接口;

/**
 * Created by archy on 6/14/16.
 */
public class Employee implements  Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /*
    Compares employees by salary
     */
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
