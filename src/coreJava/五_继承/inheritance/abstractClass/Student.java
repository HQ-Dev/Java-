package src.核心技术java.五_继承.inheritance.abstractClass;

/**
 * Created by archy on 6/7/16.
 */
public class Student extends Person {
    private String major;

    public Student(String n, String m) {
        super(n);
        this.major = m;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
