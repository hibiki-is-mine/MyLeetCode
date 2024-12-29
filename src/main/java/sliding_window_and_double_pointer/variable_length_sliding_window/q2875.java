package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 2875. 无限数组的最短子数组
 * <p>
 * 给你一个下标从 0 开始的数组 nums 和一个整数 target 。
 * <p>
 * 下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。
 * <p>
 * 请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q2875 {

    @Test
    public void test(){
        int[] nums = {1,2,2,2,1,2,1,2,1,2,1};
        int target = 83;
        System.out.println(minSizeSubarray(nums,target));
    }
    public int minSizeSubarray(int[] nums, int target) {
        int total  = 0;
        int additionalLen = 0;
        for (int n : nums){
            total += n;
        }
        if (total == 0){
            return target == 0 ? 0 : -1;
        }
        if(target > total){
            additionalLen = nums.length * (target / total);
            target -= total * (target / total);
        } else if (target == total){
            return nums.length;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length * 2; right++){
            sum += nums[right % nums.length];

            while (sum >= target){
                if (sum == target){
                    min = Math.min(min, right - left + 1);
                }
                sum -= nums[left % nums.length];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min + additionalLen;
    }

}
