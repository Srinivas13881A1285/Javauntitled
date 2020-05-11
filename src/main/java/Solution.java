import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x : nums){
            int index = Math.abs(x) - 1;

            if(nums[index] < 0){
                set.add(Math.abs(x));
            }else{
                nums[index] = -nums[index];
            }

        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,1,1};
        List<Integer> duplicates = new Solution().findDuplicates(nums);
        duplicates.forEach(System.out::println);
    }
}