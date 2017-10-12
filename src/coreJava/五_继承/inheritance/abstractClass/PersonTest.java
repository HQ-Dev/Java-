package src.核心技术java.五_继承.inheritance.abstractClass;

/**
 * This program demonstrates abstract classes
 * Created by archy on 6/7/16.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        // fill the peoper array with Student and Employee objects
        people[0] = new Employee("Harray Hacker", 50000, 1989, 8, 15);
        people[1] = new Student("Archy", "Compute Science");

        for (Person person : people) {
            System.out.println(person.getName() + ", " + person.getDescription());
        }
    }
}
