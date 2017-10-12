package src.核心技术java.六_接口与内部类.接口.对象克隆;

/**
 * Created by archy on 6/15/16.
 */
public class CloneTest {

    public static void main(String[] args) {

        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
