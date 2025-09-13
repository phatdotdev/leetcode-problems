
import java.util.HashMap;

public class TwoSum {

    public class Solution {
    public int[] twoSum(int[] nums, int target){
        int[] indices = new int[2];
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer complement = target - nums[i];
            if(seen.containsKey(complement)){
                indices[0] = seen.get(complement);
                indices[1] = i;
                return indices;
            } else {
                seen.put(nums[i], i);
            }
        }
        return indices;
    }
}
}