package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cyj
 * @date 2024/12/10
 */
public class q2779 {
    @Test
    public void test(){
        int[] nums = {4,6,1,2};
        int k = 2;
        System.out.println(maximumBeauty(nums,k));
    }


    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < nums.length){
            while (nums[right] - nums[left] > 2 * k){
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}
