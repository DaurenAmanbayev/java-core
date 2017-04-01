package strings;

import java.util.StringJoiner;

/**
 * Created by aksuryawanshi on 3/31/17.
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        stringJoiner.add("akash")
                .add("suryawanshi");
        System.out.println(stringJoiner.toString());
    }
}
