class Solution:
    def longestPalindrome(self, s: str) -> str:
        t = "^#" + "#".join(list(s)) + "#$"
        P = [0] * t.__len__()
        center = 0; right = 0
        for i in range(2, t.__len__()):
            mirror = 2*center - i
            if i - 1 - P[i] >= 0 and i + 1 + P[i] < len(t) and i < right:
                P[i] = min(right - i, P[mirror])
            while P[i - 1 - P[i]] == P[i + 1 + P[i]]:
                P[i] = P[i] + 1
            if i + P[i] > right:
                center = i; right = i + P[i]
        maxLen = 0; centerIndex = 0
        for i in range(t.__len__()):
            if P[i] > maxLen:
                maxLen = P[i]
                centerIndex = i
        start = (centerIndex - maxLen) // 2
        return s[start: start + maxLen]