public class MedianOfTwoSortedArrays {
    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double median = 0;
            if(nums1.length > nums2.length){
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int total = nums1.length + nums2.length;
            int half = (nums1.length + nums2.length + 1) / 2;
            int left = 0, right = nums1.length;
            while(left <= right){
                int i = (left + right) / 2;
                int j = half - i;

                int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
                int r1 = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
                int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int r2 = j == nums2.length ? Integer.MAX_VALUE : nums2[j];

                if(l1 <= r2 && l2 <= r1 ){
                    if(total % 2 == 0){
                        median = ((l1 > l2 ? l1 : l2) +(r1 < r2 ? r1 : r2)) / 2.0;
                    }
                    else {
                        median = l1 > l2 ? l1: l2;
                    }
                    break;
                }
                else if(l1 > r2) right = i - 1;
                else left = i + 1;
            }
            return median;
        }
    }
}