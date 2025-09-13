/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  let index1 = 0,
    index2 = 0,
    prev,
    current;
  let n = nums1.length + nums2.length;
  while (index1 + index2 <= Math.floor(n / 2)) {
    prev = current;
    if (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] <= nums2[index2]) {
        current = nums1[index1];
        index1++;
      } else {
        current = nums2[index2];
        index2++;
      }
    } else if (index1 < nums1.length) {
      current = nums1[index1];
      index1++;
    } else {
      current = nums2[index2];
      index2++;
    }
  }
  if (n % 2 === 0) {
    return (prev + current) / 2;
  } else {
    return current;
  }
};
(nums1 = [1, 2]), (nums2 = [3, 4]);
console.log(findMedianSortedArrays(nums1, nums2));
