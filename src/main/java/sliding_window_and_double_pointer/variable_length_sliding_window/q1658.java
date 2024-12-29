package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q1658 {

    @Test
    public void test(){
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums,x));
    }
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(sum < x && left < nums.length){
            sum += nums[left];
            left++;
            if (sum == x){
                min = left;
            }
        }
        left--;
        while (left < right){
            sum += nums[right];

            while (sum > x && left >= 0){
                sum -= nums[left];
                left--;
            }
            if (sum == x) {
                min = Math.min(min, nums.length - right + left + 1);
            }
            right--;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
