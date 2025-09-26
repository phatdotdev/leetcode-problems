
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old)
                            continue;
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (endSet.contains(newWord))
                            return level + 1;
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    arr[i] = old;
                }
            }
            visited.addAll(nextLevel);
            beginSet = nextLevel;
            level++;
        }
        return 0;
    }
}

/*
 * public int ladderLength(String beginWord, String endWord, List<String>
 * wordList) {
 * Set<String> dict = new HashSet<>(wordList);
 * if (!dict.contains(endWord))
 * return 0;
 * Map<String, Integer> level = new HashMap<>();
 * Queue<String> queue = new LinkedList<>();
 * level.put(beginWord, 1);
 * queue.offer(beginWord);
 * while (!queue.isEmpty()) {
 * int size = queue.size();
 * for (int i = 0; i < size; i++) {
 * String word = queue.poll();
 * int currentLevel = level.get(word);
 * for (String neighbor : neighbors(word, dict)) {
 * 
 * if (!level.containsKey(neighbor)) {
 * if (neighbor.equals(endWord))
 * return currentLevel + 1;
 * level.put(neighbor, currentLevel + 1);
 * queue.offer(neighbor);
 * }
 * }
 * }
 * }
 * return 0;
 * }
 * 
 * private List<String> neighbors(String word, Set<String> dict) {
 * List<String> res = new ArrayList<>();
 * char[] arr = word.toCharArray();
 * for (int i = 0; i < arr.length; i++) {
 * char old = arr[i];
 * for (char c = 'a'; c <= 'z'; c++) {
 * if (c == old)
 * continue;
 * arr[i] = c;
 * String newWord = new String(arr);
 * if (dict.contains(newWord))
 * res.add(newWord);
 * }
 * arr[i] = old;
 * }
 * return res;
 * }
 */