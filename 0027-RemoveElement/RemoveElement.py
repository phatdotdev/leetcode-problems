from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        last = len(nums) - 1
        for i in range(last, -1, -1):
            if nums[i] == val:
                nums[i] = nums[last]
                last -= 1
        return last + 1
            