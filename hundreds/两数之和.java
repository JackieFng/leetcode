package hundreds;

import java.util.Arrays;

/**
 * @author: jackie
 * @date: 2023/7/18 10:32
 **/
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int result = nums[left] + nums[right];
            if (result > target) {
                right--;
            } else if (result < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }
}
