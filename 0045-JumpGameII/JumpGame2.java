
public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}

/*
 * public int jump(int[] nums) {
 * int n = nums.length;
 * if (n <= 1)
 * return 0;
 * int[] step = new int[n];
 * Arrays.fill(step, -1);
 * step[0] = 0;
 * 
 * for (int i = 0; i < n; i++) {
 * int m = nums[i];
 * for (int j = 1; j <= m && i + j < n; j++) {
 * if (step[i + j] == -1 || step[i + j] > step[i] + 1) {
 * step[i + j] = step[i] + 1;
 * }
 * }
 * }
 * return step[n - 1];
 * }
 */