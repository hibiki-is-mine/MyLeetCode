package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q1838 {

    @Test
    public void test(){
        int[] nums = {3,9,6};
        int k = 2;
        System.out.println(maxFrequency(nums,k));
    }
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        long sum = 0;
        Arrays.sort(nums);
        while (right < nums.length){
            sum += nums[right];
            if (right == 0 || nums[right-1] != nums[right] ){
                while (sum + k < (long) nums[right] * (right - left + 1)){
                    sum -= nums[left];
                    left++;
                }
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}
