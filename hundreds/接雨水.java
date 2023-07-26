package hundreds;

/**
 * @author: jackie
 * @date: 2023/7/26 17:01
 **/
public class 接雨水 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * i位置左侧最高柱子lheight,右侧最高柱子高度rheight
     * 对于height任意i位置能接的雨水量=(min(lheight,rheight) - height[i]) * 宽度(1)
     * 遍历循环每一个位置能接到的雨水相加即最后能接到的雨水总量
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            //边界两侧不接雨水
            if (i == 0 || i == len - 1) {
                continue;
            }
            int rheight = height[i];
            int lheight = height[i];
            for (int r = i + 1; r < len; r++) {
                if (height[r] > rheight) {
                    rheight = height[r];
                }
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > lheight) {
                    lheight = height[l];
                }
            }
            int h = Math.min(rheight, lheight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }
}
