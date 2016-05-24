package 核心技术java.四_对象与类;

import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

public class _4_6_对象构造 {

	public static void main(String[] args) {
		
		// fill the staff array with three Employee objects
		
		Employee1[] staff = new Employee1[3];
		
		staff[0] = new Employee1("Harry", 40000);
		staff[1] = new Employee1(60000);
		staff[2] = new Employee1();
		
		// print out imformation about all Employee objects
		
		for (Employee1 employee : staff) {
			System.out.println("name=" + employee.getName() + ","
					+ "id=" + employee.getId() + ",salary=" + 
					employee.getSalary());
		}
			
	}

	
}

class Employee1 {
	
	private static int nextId;
	
	private int id;
	private String name = ""; // instance field initialization
	private double salary;
	
	// static initialization block
	
	static {
		Random generator = new Random();
		// set nextId to a random number between 0 and 9999
		nextId = generator.nextInt(10000);
	}
	
	// object initialization block
	
	{
		id = nextId;
		nextId++;
	}
	
	// three overloaded constructors
	 public Employee1(String name, double salary) {
		 this.name = name;
		 this.salary = salary;
	 }
	 
	 public Employee1(double salary) {
		 // calls the Employee(String, double) constructor
		 this("Employee #" + nextId, salary);
	 }
	 
	 // the default contructor
	 
	 public Employee1() {
		 // name initialized to "" --see above
		 // salary not explicitly set--initializaed to 0
		 // id initialized in initialization block
	 }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	 
}
