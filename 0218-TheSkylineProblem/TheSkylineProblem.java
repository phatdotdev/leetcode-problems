
import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {

}

/*
 * public class TopNode {
 * public int x;
 * public int h;
 * public TopNode next;
 * 
 * public TopNode(int x, int h) {
 * this.x = x;
 * this.h = h;
 * }
 * 
 * public void insert(TopNode n) {
 * n.next = this.next;
 * this.next = n;
 * }
 * 
 * }
 * 
 * private final int LEFT = 0, RIGHT = 1, HEIGHT = 2;
 * 
 * public List<List<Integer>> getSkyline(int[][] buildings) {
 * TopNode head = new TopNode(0, 0);
 * head.insert(new TopNode(Integer.MAX_VALUE, 0));
 * TopNode start = head;
 * for (int[] b : buildings) {
 * int bL = b[LEFT];
 * int bR = b[RIGHT];
 * int bH = b[HEIGHT];
 * 
 * while (bL >= start.next.x) {
 * start = start.next;
 * }
 * for (TopNode t = start; bR > t.x; t = t.next) {
 * if (bH < t.h)
 * continue;
 * TopNode stop = t;
 * while (stop.next != null && stop.next.x < bR && stop.next.h <= bR) {
 * stop = stop.next;
 * }
 * if (bL <= t.x) {
 * if (bR >= stop.next.x) {
 * t.next = stop.next;
 * t.h = bH;
 * } else if (t == stop) {
 * t.insert(new TopNode(bR, t.h));
 * t.h = bH;
 * break;
 * } else {
 * stop.x = bR;
 * t.h = bH;
 * t.next = stop;
 * break;
 * }
 * } else {
 * if (bR >= stop.next.x) {
 * if (t == stop) {
 * t.insert(new TopNode(bL, bH));
 * } else {
 * t.next = stop;
 * stop.x = bL;
 * stop.h = bH;
 * }
 * break;
 * } else if (t == stop) {
 * t.insert(new TopNode(bL, bH));
 * t.next.insert(new TopNode(bR, t.h));
 * break;
 * } else {
 * t.next = stop;
 * t.insert(new TopNode(bL, bH));
 * stop.x = bR;
 * break;
 * }
 * }
 * t = stop;
 * }
 * }
 * List<List<Integer>> skyline = new ArrayList<>();
 * 
 * if (head.h == 0)
 * head = head.next;
 * while (head != null) {
 * int height = head.h;
 * skyline.add(List.of(head.x, height));
 * while ((head = head.next) != null && head.h == height) {
 * }
 * }
 * 
 * return skyline;
 * }
 */

/*
 * public List<List<Integer>> getSkyline(int[][] buildings) {
 * List<int[]> points = new ArrayList<>();
 * for (int[] b : buildings) {
 * points.add(new int[]{b[0], -b[2]}); // start
 * points.add(new int[]{b[1], b[2]}); // end
 * }
 * 
 * // Sắp xếp theo x tăng dần, sau đó theo height
 * points.sort((a, b) -> {
 * if (a[0] != b[0]) return a[0] - b[0];
 * return a[1] - b[1];
 * });
 * 
 * List<List<Integer>> res = new ArrayList<>();
 * PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
 * pq.add(0);
 * int prevHeight = 0;
 * 
 * for (int[] p : points) {
 * if (p[1] < 0) pq.add(-p[1]); // start
 * else pq.remove(p[1]); // end
 * 
 * int currHeight = pq.peek();
 * if (currHeight != prevHeight) {
 * res.add(List.of(p[0], currHeight));
 * prevHeight = currHeight;
 * }
 * }
 * return res;
 * }
 * 
 */