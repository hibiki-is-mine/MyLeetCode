package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

/**
 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
 *
 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
 *
 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
 *
 * 子数组指的是数组中一段连续 非空 的元素序列。
 *
 * @author cyj
 * @date 2024/12/04
 */
public class q2653 {

    @Test
    public void test(){
        int[] subarrayBeauty = getSubarrayBeauty(new int[]{-3,1,2,-3,0,-3}, 2, 1);
        for (int i : subarrayBeauty) {
            System.out.println(i);
        }
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[]count = new int[101];
        int negSize = 0;
        int posSize = 0;

        for (int i = 0 ; i < nums.length; i++){

        }


        return null;
    }



}
