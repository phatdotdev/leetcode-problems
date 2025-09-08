
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int strLen = s.length(), wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int right = i; right + wordLen <= strLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);
                if (map.containsKey(sub)) {
                    count++;
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    if (seen.get(sub) > map.get(sub)) {
                        while (seen.get(sub) > map.get(sub)) {
                            String leftWord = s.substring(left, left + wordLen);
                            seen.put(leftWord, seen.get(leftWord) - 1);
                            left += wordLen;
                            count--;
                        }
                    } else {
                        if (count == words.length) {
                            // Truot left
                            list.add(left);
                            String leftWord = s.substring(left, left + wordLen);
                            seen.put(leftWord, seen.get(leftWord) - 1);
                            left += wordLen;
                            count--;
                        }
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return list;
    }
}
