import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class BigIntegerSort {
    public static void main(String[] args) {

        String[] unsorted = {"1234", "33444442", "23", "1"};
        String[] strings = bigSort(unsorted);
        System.out.println(Arrays.toString(strings));
    }

    static String[] bigSort(String[] unsorted) {
        Comparator<String> ascStringComp = (String s1, String s2) -> {
            if (s1.length() == s2.length())
                return s1.compareTo(s2);
            else {
                return s1.length() - s2.length();
            }
        };

        return Arrays.stream(unsorted).sorted(ascStringComp).toArray(String[]::new);
    }

    static String[] bigSortBig(String[] unsorted) {
        return Arrays.stream(unsorted)
                .map(BigInteger::new)
                .sorted()
                .map(String::valueOf)
                .toArray(String[]::new);
    }
}