package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 *
 * @author cyj
 * @date 2024/12/05
 */
public class q1493 {

    @Test
    public void test(){
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                zeroCount++;
            }
            count++;
            if (zeroCount > 1){
                while (zeroCount > 1){
                    if (nums[i - count+1] == 0){
                        zeroCount--;
                    }
                    count--;
                }
            }
            max = Math.max(max, count);
        }

        return max-1;
    }
}
