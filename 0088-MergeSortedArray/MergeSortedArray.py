from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        p1, p2, p = m-1, n-1, m+n-1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] >= nums2[p2]:
                nums1[p] = nums1[p1] 
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
            p -= 1
        while p2 >= 0:
            nums1[p] = nums2[p2]
            p2 -= 1
            p -= 1

# class Solution:
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         if n == 0:
#             return
#         i, j = 0, 0
#         for i in range(m):
#             if nums1[i] <= nums2[j]:
#                 continue
#             else:
#                 t = nums1[i]
#                 nums1[i] = nums2[j]
#                 while j < n - 1 and nums2[j+1] < t:
#                     nums2[j] = nums2[j+1]
#                     j += 1
#                 nums2[j] = t
#         for j in range(n):
#             nums1[m+j] = nums2[j]
            