
import java.util.Stack;

public class LargestRectangleHistogram {

}

/*
 * public int largestRectangleArea(int[] heights) {
 * int maxArea = 0;
 * Stack<Integer> stack = new Stack<>();
 * int n = heights.length;
 * for (int i = 0; i <= n; i++) {
 * int curr = (i == n ? 0 : heights[i]);
 * while (!stack.isEmpty() && curr < heights[stack.peek()]) {
 * int height = heights[stack.pop()];
 * int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
 * maxArea = Math.max(height * width, maxArea);
 * }
 * stack.push(i);
 * }
 * 
 * return maxArea;
 * }
 */