
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        boolean[] used = new boolean[length];
        Arrays.fill(used, false);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        trackback(nums, used, current, res);

        return res;
    }

    private static void trackback(int[] nums, boolean [] used, List<Integer> current, List<List<Integer>> res){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            current.add(nums[i]);
            trackback(nums, used, current, res);
            
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    
}
