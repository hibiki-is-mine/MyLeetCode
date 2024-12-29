package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案
 *
 * @author cyj
 * @date 2024/12/20
 */
public class q18 {
    @Test
    public void test(){
        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        int target =1000000000;
        fourSum(nums,target).forEach(System.out::println);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        long sum;
        for(int i = 0;i < nums.length - 3;i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //最大值小于目标值，则无法满足条件，直接跳过
            if ((long) nums[i] + nums[nums.length -3] + nums[nums.length -2] + nums[nums.length - 1] < target){
                continue;
            }
            //最小值大于目标值，则无法满足条件，直接跳过
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //最大值小于目标值，则无法满足条件，直接跳过
                if ((long)nums[i] + nums[j] + nums[nums.length-1] + nums[nums.length - 2] < target){
                    continue;
                }
                //最小值大于目标值，则无法满足条件，直接跳过
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
        }
        return ans;
    }
}
