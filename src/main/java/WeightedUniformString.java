import java.util.HashSet;
import java.util.Set;

public class WeightedUniformString {
    public static void main(String[] args) {
        String[] result = weightedUniformStrings("aaabbbbcccddd", new int[]{
                9,
                7,
                8,
                12,
                5}
        );
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> weights = new HashSet<>();

        int firstCharWt = s.charAt(0) - 'a' + 1;
        weights.add(firstCharWt);

        String[] result = new String[queries.length];

        int count = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else
                count = 1;

            int currCharWt = s.charAt(i) - 'a' + 1;

            weights.add(count * currCharWt);
        }


        for (int i = 0; i < queries.length; i++) {
            if (weights.contains(queries[i]))
                result[i] = "Yes";
            else
                result[i] = "No";
        }
        return result;
    }
}
