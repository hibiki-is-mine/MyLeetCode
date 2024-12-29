package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. 统计好子数组的数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 *
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 *
 * 子数组 是原数组中一段连续 非空 的元素序列。
 *
 * @author cyj
 * @date 2024/12/12
 */
public class q2537 {
    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        int k = 10;
        System.out.println(countGood(nums, k));
    }
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        long result = 0;
        int maxCount = 0;
        while (right < nums.length) {
            Integer n = countMap.merge(nums[right], 1, Integer::sum);
            maxCount += n - 1;
            while (maxCount >= k){
                result += nums.length - right;
                Integer m = countMap.merge(nums[left], -1, Integer::sum);
                maxCount -= m;
                left++;
            }
            right++;
        }
        return result;
    }
}
