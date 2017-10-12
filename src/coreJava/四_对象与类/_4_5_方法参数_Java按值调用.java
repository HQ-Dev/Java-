package coreJava.四_对象与类;

public class _4_5_方法参数_Java按值调用 {
	
	public static void main(String[] args) {
		/*
		 * Test1: Methods can't modify numeric parameters
		 */
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent=" + percent);
		tripleValue(percent);
		System.out.println("After: percent=" + percent);
		
		
		/*
		 * Test2: Methods can change the state of object parameters
		 */
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before: salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary=" + harry.getSalary());
		
		
		/*
		 * Test3: Methods can't attach new Object to object parameters
		 */
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 70000);
		Employee b = new Employee("Bob", 60000);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}
	
	public static void tripleValue(double x) {
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}
	
	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}
	
	public static void swap(Employee a, Employee b) {
		Employee temp = a;
		a = b;
		b = temp;
		System.out.println("End of method: x=" + a.getName());
		System.out.println("End of method: y=" + b.getName());
	}
}

class Employee {
	
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
