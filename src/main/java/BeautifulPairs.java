import java.util.HashMap;
import java.util.Map;

public class BeautifulPairs {

    static int beautifulPairs(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        for (int i : B) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                count++;
            } else
                map.put(i, 1);
        }

        int maxVal = 1;
        Map<Integer, Integer> mp = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mp.put(entry.getValue(), map.getOrDefault(map.get(entry.getValue()), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1 && entry.getKey() > maxVal)
                maxVal = entry.getKey();
        }

        return count + maxVal;
    }


    public static void main(String[] args) {
        int i = beautifulPairs(new int[]{3,5,7,11,5,8}, new int[]{5,7,11,10,5,8});
        System.out.println("i = " + i);
    }
}
