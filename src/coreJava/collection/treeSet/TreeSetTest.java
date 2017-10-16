package coreJava.collection.treeSet;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**'
 * This program sorts a set of item by comparing
 * @author Archy
 **/
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String descrA = o1.getDescription();
                String descrB = o2.getDescription();
                return descrA.compareTo(descrB);
            }
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
