public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest)
                return false;
            farthest = farthest > i + nums[i] ? farthest : i + nums[i];
        }
        return true;
    }
}

/*
 * public boolean canJump(int[] nums) {
 * if (nums.length <= 1)
 * return true;
 * if (nums[0] == 0)
 * return false;
 * int i = nums.length - 2;
 * while (i >= 0) {
 * if (nums[i] == 0) {
 * int zeroIndex = i;
 * i--;
 * while (i >= 0 && nums[i] + i <= zeroIndex) {
 * if (i == 0)
 * return false;
 * i--;
 * }
 * } else {
 * i--;
 * }
 * }
 * return true;
 * }
 */