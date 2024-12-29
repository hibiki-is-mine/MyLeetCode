package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import java.util.Arrays;

/**
 * LCP 28. 采购方案
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * @author cyj
 * @date 2024/12/19
 */
public class LCP28 {

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0;
        int sum;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            sum = nums[left] + nums[right];
            if (sum <= target){
                ans += right - left;
                left++;
            } else {
                right--;
            }
        }
        return (int) (ans % 1000000007);
    }
}
