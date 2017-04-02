package collections.sorting;

import java.util.Comparator;

/**
 * Created by aksuryawanshi on 4/1/17.
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.id - o2.id;
    }
}
