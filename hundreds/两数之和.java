package hundreds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jackie
 * @date: 2023/7/18 10:32
 **/
public class 两数之和 {

    /**
     * 双指针法
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 哈希
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
