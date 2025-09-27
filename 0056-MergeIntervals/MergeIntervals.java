
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.Queue;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(interval[1], current[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

/*
 * public int[][] merge(int[][] intervals) {
 * Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
 * List<int[]> res = new ArrayList<>();
 * int[] curr = intervals[0];
 * for (int i = 1; i < intervals.length; i++) {
 * if (intervals[i][0] <= curr[1]) {
 * curr[1] = Math.max(curr[1], intervals[i][1]);
 * } else {
 * res.add(curr);
 * curr = intervals[i];
 * }
 * }
 * res.add(curr);
 * return res.stream().toArray(size -> new int[size][]);
 * }
 */

/*
 * public int[][] merge(int[][] intervals) {
 * Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
 * Queue<Integer> queue = new LinkedList<>();
 * 
 * int from = intervals[0][0], to = intervals[0][1];
 * for (int i = 1; i < intervals.length; i++) {
 * if (intervals[i][0] <= to) {
 * to = Math.max(to, intervals[i][1]);
 * } else {
 * queue.offer(from);
 * queue.offer(to);
 * from = intervals[i][0];
 * to = intervals[i][1];
 * }
 * }
 * queue.offer(from);
 * queue.offer(to);
 * int n = queue.size() / 2;
 * int[][] res = new int[n][2];
 * for (int i = 0; i < n; i++) {
 * res[i][0] = queue.poll();
 * res[i][1] = queue.poll();
 * }
 * return res;
 * }
 */