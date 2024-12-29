package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays;

import org.junit.Test;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * @author cyj
 * @date 2024/12/17
 */
public class q930 {

    @Test
    public  void test() {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 = 0;
        int count2 = 0;
        int sum = 0;
        int right = 0;
        int left1 = 0;
        int left2 = 0;
        while (right < nums.length){
            sum += nums[right];
            while (left1 <= right && sum >=goal){
                sum -= nums[left1];
                count1 += right - left1 +1;
                left1++;
            }
            while (left2 <= right && sum >= goal + 1){
                sum -= nums[left2];
                count2 += right - left2 +1;

                left2++;
            }
            right++;
        }
        return count1 - count2;
    }
}
