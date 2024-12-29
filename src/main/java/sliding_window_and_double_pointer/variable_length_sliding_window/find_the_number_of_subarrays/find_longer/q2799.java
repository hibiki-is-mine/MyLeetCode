package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 2799. 统计完全子数组的数目
 * <p>
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * <p>
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * <p>
 * 返回数组中 完全子数组 的数目。
 * <p>
 * 子数组 是数组中的一个连续非空序列
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q2799 {
    @Test
    public void test() {
        int[] nums = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }
        int setSize = set.size();
        int[] count = new int[2001];
        int countLen = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            if (count[nums[right]] == 0){
                countLen++;
            }
            count[nums[right]]++;
            while(countLen == setSize){
                result += nums.length - right;
                count[nums[left]]--;
                if (count[nums[left]] == 0){
                    countLen--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
