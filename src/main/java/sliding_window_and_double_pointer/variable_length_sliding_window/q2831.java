package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

import java.util.*;

/**
 * 2831. 找出最长等值子数组
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * <p>
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * <p>
 * 子数组 是数组中一个连续且可能为空的元素序列。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q2831 {
    @Test
    public void test(){
        int[] nums = {1,1,2,2,1,1};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        System.out.println(longestEqualSubarray(list,k));
    }
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int[] count = new int[nums.size() + 1];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int result = 0;
        while (right < nums.size()){
            int len = ++count[nums.get(right)];
            maxLen = Math.max(maxLen, len);
            while ( right - left + 1 - maxLen > k){
                count[nums.get(left)]--;
                left++;
            }
            result = Math.max(result, maxLen);
            right++;
        }
        return result;
    }
}
