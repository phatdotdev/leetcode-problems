class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {
            ")": "(",
            "}": "{",
            "]": "["
        }
        for c in s:
            len = stack.__len__()
            if c in mapping.values():
                stack.append(c)
            elif c in mapping:
                if not stack or stack[-1] != mapping[c]:
                    return False
                stack.pop()
            else:
                return False
            
        return not stack