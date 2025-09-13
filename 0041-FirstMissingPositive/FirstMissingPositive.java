
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }
}

/*
 * public int firstMissingPositive(int[] nums) {
 * int minPos = Integer.MAX_VALUE, maxPos = 0;
 * Set<Integer> set = new HashSet<>();
 * for (int num : nums) {
 * if (num > 0) {
 * minPos = minPos < num ? minPos : num;
 * maxPos = maxPos > num ? maxPos : num;
 * set.add(num);
 * }
 * }
 * if (maxPos == 0)
 * return 1;
 * if (minPos > 1)
 * return 1;
 * for (int num = minPos + 1; num < maxPos; num++) {
 * if (!set.contains(num))
 * return num;
 * }
 * return maxPos + 1;
 * }
 */