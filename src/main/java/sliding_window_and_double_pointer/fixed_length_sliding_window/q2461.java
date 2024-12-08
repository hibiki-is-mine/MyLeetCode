package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

/**
 * 2461. 长度为 K 子数组中的最大和
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * <p>
 * 子数组的长度是 k，且
 * <p>
 * 子数组中的所有元素 各不相同 。
 * <p>
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 *
 * @author cyj
 * @date 2024/11/29
 */
public class q2461 {
    @Test
    public void test(){
        int[] nums = new int[]{1,5,4,2,9,9,9};
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        int sunLength = 0;
        int[] numsArrays = new int[10];

        for (int i = 0; i < nums.length; i++){
            if (i < k){
                if (numsArrays[nums[i]]==0){
                    numsArrays[nums[i]]++;
                    currentSum+=nums[i];
                    sunLength++;
                }
            } else {
                if (numsArrays[nums[i]]==0){
                    currentSum+=nums[i];
                    currentSum-=nums[i-k];
                    numsArrays[nums[i]]++;
                    numsArrays[nums[i-k]]--;
                } else {
                    currentSum-=nums[i-k];
                    numsArrays[nums[i-k]]--;
                    sunLength--;
                }
            }
            if (sunLength == k){
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }
}
