package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.*;

/**
 * 15. 三数之和
 * 已解答
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author cyj
 * @date 2024/12/19
 */
public class q15 {
    @Test
    public void test(){
        int[] nums = {0,0,0};
        threeSum(nums).forEach(System.out::println);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 &&nums[i] == nums[i -1]){
                continue;
            }
            if (nums[i] + nums[nums.length-1] + nums[nums.length - 2] < 0){
                continue;
            }
            if (nums[i] > 0 ){
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    }while (left < right &&nums[left] == nums[left - 1]);
                    do {
                        right--;
                    }
                    while (right > left && nums[right] == nums[right + 1]);
                }

            }
        }
        return ans;
    }
}
