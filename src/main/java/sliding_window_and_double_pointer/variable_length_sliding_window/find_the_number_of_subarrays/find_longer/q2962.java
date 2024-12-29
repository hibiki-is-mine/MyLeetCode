package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 * <p>
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q2962 {
    @Test
    public void test(){
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(nums,k));
    }

    public long countSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        for (int n : nums){
            max = Math.max(max, n);
        }
        long result = 0;
        while (right < nums.length){
          if (nums[right] == max){
              count++;
          }
            while(count >= k){
                result += nums.length - right;
                if (nums[left] == max){
                    count--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
