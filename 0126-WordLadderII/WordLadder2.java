
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();

        if (!dict.contains(endWord))
            return res;

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        level.put(beginWord, 0);

        boolean found = false;
        int shortestLevel = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> visitedLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currentLevel = level.get(word);
                if (currentLevel > shortestLevel)
                    break;
                for (String neighbor : neighbors(word, dict)) {
                    if (!level.containsKey(neighbor)) {
                        level.put(neighbor, currentLevel + 1);
                        queue.offer(neighbor);
                        visitedLevel.add(neighbor);
                        parents.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
                    } else if (level.get(neighbor) == currentLevel + 1) {
                        parents.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
                    }
                    if (neighbor.equals(endWord)) {
                        found = true;
                        shortestLevel = currentLevel + 1;
                    }
                }
            }
            dict.removeAll(visitedLevel);
            if (found)
                break;
        }

        if (!level.containsKey(endWord))
            return res;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, path, parents, res);

        return res;
    }

    private void backtrack(String word, String begin, List<String> path, Map<String, List<String>> parents,
            List<List<String>> res) {
        if (word.equals(begin)) {
            List<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }
        for (String p : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(p);
            backtrack(p, begin, path, parents, res);
            path.remove(path.size() - 1);
        }
    }

    private List<String> neighbors(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old)
                    continue;
                arr[i] = c;
                String newWord = new String(arr);
                if (dict.contains(newWord))
                    res.add(newWord);
            }
            arr[i] = old;
        }
        return res;
    }
}

/*
 * public List<List<String>> findLadders(String beginWord, String endWord,
 * List<String> wordList) {
 * Set<String> dict = new HashSet<>(wordList);
 * List<List<String>> res = new ArrayList<>();
 * if (!dict.contains(endWord))
 * return res;
 * 
 * Map<String, Integer> level = new HashMap<>();
 * Map<String, List<String>> parents = new HashMap<>();
 * Queue<String> queue = new LinkedList<>();
 * queue.offer(beginWord);
 * level.put(beginWord, 0);
 * 
 * while (!queue.isEmpty()) {
 * String word = queue.poll();
 * List<String> neighbors = neighbors(word, dict);
 * for (String neighbor : neighbors) {
 * if (!level.containsKey(neighbor)) {
 * level.put(neighbor, level.get(word) + 1);
 * parents.put(neighbor, new ArrayList<>(List.of(word)));
 * queue.offer(neighbor);
 * } else if (level.get(neighbor) == level.get(word) + 1) {
 * List<String> p = parents.getOrDefault(neighbor, new ArrayList<>());
 * p.add(word);
 * parents.put(neighbor, p);
 * }
 * }
 * }
 * 
 * if (!parents.containsKey(endWord))
 * return res;
 * List<String> path = new ArrayList<>();
 * path.add(endWord);
 * backtrack(endWord, beginWord, parents, path, res);
 * 
 * return res;
 * }
 * 
 * private void backtrack(String word, String begin, Map<String, List<String>>
 * parents,
 * List<String> path,
 * List<List<String>> res) {
 * if (word.equals(begin)) {
 * List<String> tmp = new ArrayList<>(path);
 * Collections.reverse(tmp);
 * res.add(tmp);
 * return;
 * }
 * for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
 * path.add(parent);
 * backtrack(parent, begin, parents, path, res);
 * path.remove(path.size() - 1);
 * }
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