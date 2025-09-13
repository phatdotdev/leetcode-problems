
import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (final int num : nums) {
            minVal = minVal < num ? minVal : num;
            maxVal = maxVal > num ? maxVal : num;
        }
        if (maxVal == minVal)
            return 0;
        int n = nums.length, maxGap = 0;
        int bucketSize = (maxVal - minVal + n - 2) / (n - 1);
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        int[] max = new int[bucketCount], min = new int[bucketCount];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int index = (val - minVal) / bucketSize;
            min[index] = min[index] < val ? min[index] : val;
            max[index] = max[index] > val ? max[index] : val;
        }
        int prevMax = max[0];
        for (int i = 1; i < bucketCount; i++) {
            minVal = min[i];
            maxVal = max[i];
            if (minVal == Integer.MAX_VALUE)
                continue;
            int gap = minVal - prevMax;
            maxGap = maxGap > gap ? maxGap : gap;
            prevMax = maxVal;
        }
        return maxGap;
    }
}
