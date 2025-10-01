
import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (count[i - min] > n / 3) {
                res.add(i);
            }
        }
        return res;
    }
}

/*
 * public List<Integer> majorityElement(int[] nums) {
 * int n = nums.length;
 * List<Integer> res = new ArrayList<>();
 * Map<Integer, Integer> map = new HashMap<>();
 * for (int num : nums) {
 * map.put(num, map.getOrDefault(num, 0) + 1);
 * }
 * for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
 * if (entry.getValue() > n / 3) {
 * res.add(entry.getKey());
 * }
 * }
 * Collections.sort(res);
 * return res;
 * }
 */