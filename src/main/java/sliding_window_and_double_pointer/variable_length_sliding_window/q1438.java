package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * @author cyj
 * @date 2024/12/18
 */
public class q1438 {
    @Test
    public void test(){
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }

    public int longestSubarray(int[] nums, int limit) {
        int right = 0;
        int left = 0;
        int ans = 0;
        int current = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        while (right < nums.length){

        }
        return ans;
    }
}
