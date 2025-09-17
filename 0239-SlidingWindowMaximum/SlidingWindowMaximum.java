
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k)
            return new int[0];
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek()[0] < nums[i]) {
                heap.poll();
            }
            while (!heap.isEmpty() && heap.peek()[1] < i - k + 1) {
                heap.poll();
            }
            heap.offer(new int[] { nums[i], i });
            if (i - k + 1 >= 0) {
                result[i - k + 1] = heap.peek()[0];
            }
        }
        return result;
    }
}

/*
 * USE DEQUE
 * public int[] maxSlidingWindow(int[] nums, int k) {
 * int n = nums.length;
 * if (k > n)
 * return new int[0];
 * int[] result = new int[n - k + 1];
 * Deque<Integer> deque = new ArrayDeque<>();
 * for (int i = 0; i < n; i++) {
 * if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
 * deque.pollFirst();
 * }
 * while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
 * deque.pollLast();
 * }
 * deque.offerLast(i);
 * if (i >= k - 1) {
 * result[i - k + 1] = nums[deque.peekFirst()];
 * }
 * }
 * 
 * return result;
 * }
 */