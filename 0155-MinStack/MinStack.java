
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<int[]> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        int currentMin = val;
        if (!stack.isEmpty()) {
            currentMin = Math.min(val, stack.getLast()[1]);
        }
        stack.addLast(new int[] { val, currentMin });
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.removeLast();
        }
    }

    public int top() {
        return stack.getLast()[0];
    }

    public int getMin() {
        return stack.getLast()[1];
    }
}

/*
 * 
 * import java.util.Stack;
 * 
 * public class MinStack {
 * private Stack<Integer> stack;
 * private Stack<Integer> minStack;
 * 
 * public MinStack() {
 * stack = new Stack<>();
 * minStack = new Stack<>();
 * }
 * 
 * public void push(int val) {
 * stack.push(val);
 * if (!minStack.isEmpty() || val <= minStack.peek()) {
 * minStack.push(val);
 * }
 * }
 * 
 * public void pop() {
 * int value = stack.pop();
 * if (value == minStack.peek()) {
 * minStack.pop();
 * }
 * }
 * 
 * public int top() {
 * return stack.peek();
 * }
 * 
 * public int getMin() {
 * return minStack.peek();
 * }
 * }
 * 
 */