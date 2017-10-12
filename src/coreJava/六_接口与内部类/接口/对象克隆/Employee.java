package src.核心技术java.六_接口与内部类.接口.对象克隆;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by archy on 6/15/16.
 */
public class Employee implements  Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException {
        // call Object.clone()
        Employee cloned = (Employee) super.clone();

        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    // set the hire day to a given date.
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ", hireDay="
                + hireDay + "]";
    }
}
