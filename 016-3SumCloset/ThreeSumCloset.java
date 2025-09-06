
import java.util.Arrays;


public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int num = nums[i] + nums[l] + nums[r];
                if((target - num > 0 ? target - num : num -target) < 
                    (target - result > 0 ? target -result : result - target)){
                    result = num;
                } else if(num < target){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}