
import java.util.HashMap;

public class LongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0, left = 0, right = 0, windowLength = 0;
            HashMap<Character, Integer> map =  new HashMap<>();
            while(right < s.length()){
                if(map.get(s.charAt(right)) != null && map.get(s.charAt(right)) >= left){
                    left = map.get(s.charAt(right)) + 1;
                }
                windowLength = right - left + 1;
                maxLength = maxLength > windowLength ? maxLength : windowLength;
                map.put(s.charAt(right), right);
                right++;
            }
            return maxLength;
        }
    }
}