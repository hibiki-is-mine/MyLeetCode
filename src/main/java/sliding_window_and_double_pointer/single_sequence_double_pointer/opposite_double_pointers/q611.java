package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 * @author cyj
 * @date 2024/12/20
 */
public class q611 {
    @Test
    public void test(){
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i > 1; i--){
            if (nums[0] + nums[1] > nums[nums.length - 1]){
                return i * (i-1) * (i + 1) / 6;
            }
            if (nums[i - 2] + nums[i - 1] < nums[i]){
                continue;
            }
            int left = 0;
            int right = i - 1;
            while (left < right){
                if (nums[left] + nums[right] > nums[i]){
                    ans += right - left;
                    right--;

                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
