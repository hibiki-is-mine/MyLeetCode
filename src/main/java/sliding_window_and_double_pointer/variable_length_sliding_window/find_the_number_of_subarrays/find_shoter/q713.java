package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_shoter;

import org.junit.Test;

public class q713 {

    @Test
    public void test(){
        int[] nums = {3,4,2,5};
        int k = 100;
        int i = numSubarrayProductLessThanK(nums, k);
        System.out.println(i);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) { // 不满足要求
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
