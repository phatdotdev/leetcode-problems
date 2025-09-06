
public class SortColors {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private static void partition(int[] nums, int start, int end) {
        if (start == end)
            return;
        int first = nums[start];
        int current = start + 1;
        while (current < end && nums[current] == first)
            current++;
        if (nums[current] == first || start == end)
            return;

        int pivot = nums[current] > first ? nums[current] : first,
                left = start, right = end;
        while (left <= right) {
            if (nums[left] < pivot)
                left++;
            if (nums[right] >= pivot)
                right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        partition(nums, start, right);
        partition(nums, right + 1, end);
    }
}
/* 
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low, mid);
            low++;
            mid++;
        } else if (nums[mid] == 1) {
            mid++;
        } else { // nums[mid] == 2
            swap(nums, mid, high);
            high--;
        }
    }
}
private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
*/