package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_shoter;

import org.junit.Test;

/**
 * 2302. 统计得分小于 K 的子数组数目
 * <p>
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * <p>
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * <p>
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 *
 * @author cyj
 * @date 2024/12/16
 */
public class q2302 {
    @Test
    public void test(){
        int[] nums = {2,1,4,3,5};
        long k = 10;
        long i = countSubarrays(nums, k);
        System.out.println(i);
    }

    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int right = 0;
        int left = 0;

        while(right < nums.length){
            sum += nums[right];
            while (sum * (right - left + 1) >= k ){
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
            right ++;
        }
        return ans;
    }

}
