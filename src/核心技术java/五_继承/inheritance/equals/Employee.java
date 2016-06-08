package src.核心技术java.五_继承.inheritance.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Created by archy on 6/8/16.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month,day);
        hireDay = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        // a quick test to see if the objects are identical (相同)
        if (this == otherObject) return true;

        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())  return false;

        // now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;

        // test wheather the fields have identical values
        return Objects.equals(name,other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
         return Objects.hash(name,salary,hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary +
                ",hireDay=" + hireDay + "]";
    }

}
