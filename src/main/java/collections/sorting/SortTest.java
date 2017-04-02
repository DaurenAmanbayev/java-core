package collections.sorting;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by aksuryawanshi on 4/1/17.
 */
public class SortTest {
    public static void main(String[] args) {
        SortedSet<Person> personSortedSet = new TreeSet<>();
        personSortedSet.add(new Person("ramnath"));
        personSortedSet.add(new Person("megha"));
        personSortedSet.add(new Person("akash"));
        personSortedSet.add(new Person("megha"));

        personSortedSet.forEach(e -> System.out.println(e));

        personSortedSet.clear();

        System.out.println("--------------------------------------");

        SortedSet<Person> personSortedSet2 = new TreeSet<>(new PersonComparator());
        personSortedSet2.add(new Person(5,"ramnath"));
        personSortedSet2.add(new Person(10,"megha"));
        personSortedSet2.add(new Person(8, "akash"));
        personSortedSet2.add(new Person(1, "megha"));

        personSortedSet2.forEach(e -> System.out.println(e));

    }
}
