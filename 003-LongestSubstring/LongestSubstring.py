class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLength = 0
        seen = {}
        left = right = 0
        while(right < len(s)):
            if s[right] in seen and seen[s[right]] >= left :
                left = seen[s[right]] + 1
                
            windowLength = right - left + 1;
            maxLength = max(maxLength, windowLength)
            seen[s[right]] = right
            right += 1
        return maxLength