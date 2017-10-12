package src.核心技术java.五_继承.inheritance.abstractClass;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by archy on 6/7/16.
 */
public class Employee extends Person {

    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        super(n);
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month,day);
        hireDay = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of %.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
