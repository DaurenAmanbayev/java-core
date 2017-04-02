package collections.sorting;

/**
 * Created by aksuryawanshi on 4/1/17.
 */
public class Person implements Comparable{
    public int id;
    public String name;
    public static int count = 0;

    {
        count++;
    }

    public Person(String name) {
        this.id = count;
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public int compareTo(Object o) {
        Person other = (Person)o;
        return name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return id + " "+name;
    }
}
