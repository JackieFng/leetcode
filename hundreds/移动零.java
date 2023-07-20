package hundreds;

/**
 * @author: jackie
 * @date: 2023/7/20 10:07
 **/
public class 移动零 {

    /**
     * 将非零数，声明index记录非零数的最大下标，从index处开始补0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes02(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //非0数往左移，0往右移
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
