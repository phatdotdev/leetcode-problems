import java.util.HashMap;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff < 1 || valueDiff < 0)
            return false;

        HashMap<Long, Long> buckets = new HashMap<>();
        Long bucketSize = (long) valueDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                long oldBucket = ((long) nums[i - indexDiff - 1] - Integer.MIN_VALUE) / bucketSize;
                buckets.remove(oldBucket);
            }
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucketId = remappedNum / bucketSize;

            if (buckets.containsKey(bucketId))
                return true;
            if (buckets.containsKey(bucketId - 1) && remappedNum - buckets.get(bucketId - 1) <= valueDiff)
                return true;
            if (buckets.containsKey(bucketId + 1) && buckets.get(bucketId + 1) - remappedNum <= valueDiff)
                return true;
            buckets.put(bucketId, remappedNum);
        }
        return false;
    }
}
/*
 * TIME LIMIT EXCEEDED
 * public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int
 * valueDiff) {
 * int n = nums.length;
 * for (int i = 0; i < n; i++) {
 * int j = i + 1;
 * while (j < n && j - i <= indexDiff) {
 * if (Math.abs(nums[i] - nums[j]) <= valueDiff)
 * return true;
 * j++;
 * }
 * }
 * return false;
 * }
 */

/*
 * public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int
 * valueDiff) {
 * TreeSet<Long> set = new TreeSet<>();
 * for (int i = 0; i < nums.length; i++) {
 * Long floor = set.floor((long) nums[i] + valueDiff);
 * Long ceil = set.ceiling((long) nums[i] - valueDiff);
 * if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
 * {
 * return true;
 * }
 * set.add((long) nums[i]);
 * if (i >= indexDiff) {
 * set.remove((long) nums[i - indexDiff]);
 * }
 * }
 * return false;
 * }
 */