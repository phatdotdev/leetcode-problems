class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        if(nums1.__len__() > nums2.__len__()):
            temp = nums1
            nums1 = nums2
            nums2 = temp
        total: int = nums1.__len__() + nums2.__len__() 
        half: int = (nums1.__len__() + nums2.__len__() + 1) // 2;
        left: int = 0
        right: int = nums1.__len__()
        while left <= right:
            i = (left + right) // 2;
            j = half - i
            
            l1 = float('-inf') if i == 0 else nums1[i-1]
            r1 = float('inf') if i == nums1.__len__() else nums1[i]
            l2 = float('-inf') if j == 0 else nums2[j-1]
            r2 = float('inf') if j == nums2.__len__() else nums2[j]
            
            if l1 <= r2 and l2 <= r1:
                if total % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return float(max(l1, l2))
            
            if l1 > r2:
                right -= 1
            if l2 > r1:
                left += 1
        return float()