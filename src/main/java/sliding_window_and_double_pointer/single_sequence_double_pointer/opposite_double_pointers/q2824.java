package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 *
 * @author cyj
 * @date 2024/12/19
 */
public class q2824 {
    @Test
    public void test(){
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int target = 2;
        int i = countPairs(nums, target);
        System.out.println(i);
    }

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        int sum;
        int left = 0;
        int right = nums.size() - 1;
        while(left < right){
            sum = nums.get(left) + nums.get(right);
            if (sum < target){
                ans += right -left;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
