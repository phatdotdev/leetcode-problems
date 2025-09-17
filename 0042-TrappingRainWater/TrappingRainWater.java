public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return water;
    }
}

/*
 * public int trap(int[] height) {
 * int left = 0, right = height.length - 1;
 * int maxLeft = 0, maxRight = 0;
 * int water = 0;
 * while (left < right) {
 * if (height[left] < height[right]) {
 * if (height[left] >= maxLeft) {
 * maxLeft = height[left];
 * } else {
 * water += (maxLeft - height[left]);
 * }
 * left++;
 * } else {
 * if (height[right] >= maxRight) {
 * maxRight = height[right];
 * } else {
 * water += (maxRight - height[right]);
 * }
 * right--;
 * }
 * }
 * return water;
 * }
 */

/*
 * public int trap(int[] height) {
 * int left = 0, right = height.length - 1, water = 0;
 * while (left < right) {
 * while (left < right && height[left] < height[left + 1]) {
 * left++;
 * }
 * while (left < right && height[right] < height[right - 1]) {
 * right--;
 * }
 * if (left == right)
 * break;
 * if (height[left] <= height[right]) {
 * int i = left + 1;
 * while (i < right && height[i] < height[left]) {
 * water += (height[left] - height[i]);
 * i++;
 * }
 * left = i;
 * } else {
 * int i = right - 1;
 * while (i > left && height[i] < height[right]) {
 * water += (height[right] - height[i]);
 * i--;
 * }
 * right = i;
 * }
 * }
 * return water;
 * }
 */