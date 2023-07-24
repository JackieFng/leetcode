package hundreds;

/**
 * @author: jackie
 * @date: 2023/7/21 11:42
 **/
public class 盛水最多的容器 {

    /**
     * 双指针
     * 本题用双指针解法的疑惑点在于是否会漏掉面积最大的枚举
     * 其实可以证明为什么是移动数值较小的指针，因为当移动数值较大的指针面积s必定会小于当前双指针的面积
     * 所以做出移动数值较小的指针已经排除了其他枚举面积更小的可能
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
