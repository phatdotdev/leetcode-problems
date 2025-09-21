// import java.util.ArrayDeque;
// import java.util.Deque;

public class SimplifyPath {

}

/*
 * public String simplifyPath(String path) {
 * Deque<String> stack = new ArrayDeque<>();
 * String[] parts = path.split("/");
 * 
 * for (String part : parts) {
 * if (part.equals("") || part.equals(".")) {
 * continue;
 * } else if (part.equals("..")) {
 * if (!stack.isEmpty()) {
 * stack.pollLast();
 * }
 * } else {
 * stack.addLast(part);
 * }
 * }
 * 
 * return "/" + String.join("/", stack);
 * }
 */