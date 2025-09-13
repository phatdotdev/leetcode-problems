#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLength = 0, windowLength, left = 0;
        int seen[128];
        fill(seen, seen + 128, -1);
        for(int right = 0; right < s.length(); right++){
            char c = s.at(right);
            if(seen[c] != -1 && seen[c] >= left){
                left = seen[c] + 1;
            }
            windowLength = right - left + 1;
            maxLength = maxLength > windowLength ? maxLength : windowLength;
            seen[c] = right;
        }
        return maxLength;
    }
};