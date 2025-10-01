
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || small.peek() > num) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        return (small.peek() + large.peek()) / 2.0;
    }

}

/*
 * public class MedianFinder {
 * private PriorityQueue<Integer> small;
 * private PriorityQueue<Integer> large;
 * 
 * public MedianFinder() {
 * small = new PriorityQueue<>(Collections.reverseOrder());
 * large = new PriorityQueue<>();
 * }
 * 
 * public void addNum(int num) {
 * if (small.isEmpty() || num <= small.peek()) {
 * small.offer(num);
 * } else {
 * large.offer(num);
 * }
 * 
 * if (small.size() > large.size() + 1) {
 * large.offer(small.poll());
 * } else if (large.size() > small.size()) {
 * small.offer(large.poll());
 * }
 * }
 * 
 * public double findMedian() {
 * if (small.size() > large.size())
 * return small.peek();
 * return (small.peek() + large.peek()) / 2.0;
 * }
 * }
 */