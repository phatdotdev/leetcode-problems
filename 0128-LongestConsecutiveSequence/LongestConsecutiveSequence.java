
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    
}

/*
 * public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
*/

/*
 * public int longestConsecutive(int[] nums) {
 * if (nums.length < 1)
 * return 0;
 * int max = 1, current = 1;
 * Arrays.sort(nums);
 * for (int i = 1; i < nums.length; i++) {
 * if (nums[i] == nums[i - 1]) {
 * 
 * } else if (nums[i] == nums[i - 1] + 1) {
 * current++;
 * max = Math.max(max, current);
 * } else {
 * current = 1;
 * }
 * }
 * return max;
 * }
 */