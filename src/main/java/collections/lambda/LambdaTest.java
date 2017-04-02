package collections.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aksuryawanshi on 4/1/17.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("akash");
        list.add("megha");
        list.add("ramnath");
        list.add("suryawanshi");
        list.add("ranjana");
        list.add("rameshi bai");

        list.forEach(e -> System.out.println(e));
        list.removeIf(e -> e.matches(".*am.*"));

        System.out.println("After removing some elements");
        list.forEach(e -> System.out.println(e));
    }
}
