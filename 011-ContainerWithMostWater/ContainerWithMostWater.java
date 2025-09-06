
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int currentArea = (right - left) * 
            (height[left] <= height[right] ? height[left] : height[right]);
            if(currentArea > maxArea) maxArea = currentArea;
            if(height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
