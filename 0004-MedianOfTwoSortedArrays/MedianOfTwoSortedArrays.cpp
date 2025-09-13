#include <vector> 
#include <limits>
using namespace std;
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double median = 0;
        if(nums1.size() > nums2.size()){
            vector<int> temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int left = 0, right = nums1.size(), 
        total = nums1.size() + nums2.size(), 
        half = (nums1.size() + nums2.size() + 1) / 2;

        while(left <= right){
            int i = (left + right) / 2;
            int j = half - i;
            
            int l1 = i == 0 ? numeric_limits<int>::min() : nums1[i-1];
            int r1 = i == nums1.size() ? numeric_limits<int>::max() : nums1[i];
            int l2 = j == 0 ? numeric_limits<int>::min() : nums2[j-1];
            int r2 = j == nums2.size() ? numeric_limits<int>::max() : nums2[j];

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 0){
                    median = (max(l1, l2) + min(r1, r2)) / 2.0;
                } else {
                    median = max(l1, l2);
                }
                break;
            }else if(l1 > r2){
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return median;
    }
};