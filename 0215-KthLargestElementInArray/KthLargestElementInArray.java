
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        int val = 0;
        for (int i = 0; i < k; i++) {
            val = pq.poll();
        }
        return val;
    }
}
