
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        for(int i = 0; i < length-3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; 
            for(int j = i + 1; j < length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = length - 1;
                while(l < r){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        result.add(quad);
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    } else if(sum < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
