package src.核心技术java.五_继承.inheritance.abstractClass;

/**
 * Created by archy on 6/7/16.
 */
public abstract class Person {

    public abstract String getDescription();

    private String name;

    public Person(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

}
