class Solution:
    def twoSum(self, nums: list[int], target: int)->list[int]:
        seen: dict[int, int] = {}
        for i, num in enumerate(nums):
            complement: int = target - num
            if complement in seen:
                return [seen[complement], i]
            else:
                seen[num] = i
        return []