package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和

 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解
 *
 * @author cyj
 * @date 2024/12/19
 */
public class q16 {
    @Test
    public void test(){
        int[] nums = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum;
        int minAbs = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0;i < nums.length - 2;i ++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < target){
                sum = nums[i] + nums[nums.length - 2] + nums[nums.length - 1];
                if (Math.abs(sum - target) < minAbs){
                    ans = sum;
                    minAbs = Math.abs(sum - target);
                }
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target){
                sum = nums[i] + nums[i + 1] + nums[i + 2];
                if (Math.abs(sum - target) < minAbs){
                    ans = sum;
                    minAbs = Math.abs(sum - target);
                }
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < minAbs){
                    ans = sum;
                    minAbs = Math.abs(sum - target);
                    if (minAbs == 0){
                        break;
                    }
                }
                if (sum > target){
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                } else {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                }
            }
        }
        return ans;
    }
}
