import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Srinivas_Chintakindhi
 */

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0)
            return result;

        int[] char_counts = new int[26];

        for (char c : p.toCharArray()) {
            char_counts[c - 'a']++;
        }

        int i = 0;
        int j = 0;
        int count = p.length();

        while (j < s.length()) {

            if (char_counts[s.charAt(j++) - 'a']-- >= 1   ) {
                count--;
            }

            if (count == 0)
                result.add(i);

            if (j - i == p.length() && char_counts[s.charAt(i++) - 'a']++ >= 0){
                count++;
            }

        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length())
            return result;

        int start = 0;
        int end = p.length() - 1;

        int[] s_freq = getCharsCountStartToEnd(s,end);
        int[] p_freq = getCharsCountStartToEnd(p,end);

        if(Arrays.equals(p_freq,s_freq))
            result.add(start);

        start++;
        end++;

        while(end < s.length()){
            s_freq[s.charAt(start - 1)-'a']--;
            s_freq[s.charAt(end)-'a']++;

            if(Arrays.equals(p_freq,s_freq))
                result.add(start);

            start++;
            end++;

        }
        return result;
    }

    private int[] getCharsCountStartToEnd(String s,int end) {
        int[] s_freq = new int[26];
        for (int i = 0; i <= end; i++) {
            char c = s.charAt(i);
            s_freq[c - 'a']++;
        }
        return s_freq;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = new AllAnagrams().findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
        anagrams = new AllAnagrams().findAnagrams2("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
}
