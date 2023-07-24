package hundreds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jackie
 * @date: 2023/7/24 10:34
 **/
public class 三数之和 {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0
     * 请你返回所有和为 0 且不重复的三元组。
     * <p>
     * 类比于两数之和，固一定二，三数之和解法就可以简化成两数之和。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            //排除遍历时重复的结果集，[0,1,2,2,2,3],例如012,下次直接枚举013
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //第一层循环相当于固1，下面通过双指针(可代替双重for循环)完成定二
            int target = -nums[i];
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //双指针继续移动寻找其他可能的解,去除重复枚举
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
