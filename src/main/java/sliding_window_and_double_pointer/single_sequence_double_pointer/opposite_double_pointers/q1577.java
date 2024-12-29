package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1577. 数的平方等于两数乘积的方法数
 * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 * 类型 1：三元组 (i, j, k) ，如果 nums1[i]^2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 * 类型 2：三元组 (i, j, k) ，如果 nums2[i]^2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 *
 * @author cyj
 * @date 2024/12/20
 */
public class q1577 {
    @Test
    public void test(){
        int[] nums1 = {4,1,4,1,12};
        int[] nums2 = {3,2,5,4};
        System.out.println(numTriplets(nums1,nums2));
    }
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        return calculateTotal(nums1,nums2) + calculateTotal(nums2,nums1);

    }

    public int calculateTotal(int[] nums1, int[] nums2) {
        int ans = 0;
        int current = 0;
        for (int i =0; i < nums1.length; i++){
            if (i > 0 && nums1[i] == nums1[i - 1]){
                ans +=current;
                continue;
            }
            int sqr = nums1[i] * nums1[i];
            current = 0;
            if (nums2[nums2.length - 1] * nums2[nums2.length - 2] < sqr || nums2[0] * nums2[1] > sqr){
                continue;
            }
            int left = 0;
            int right = nums2.length - 1;
            while (left < right){
                if(nums2[left] * nums2[right] < sqr){
                    left++;
                } else if (nums2[left] * nums2[right] > sqr) {
                    right--;
                } else {
                    int lCount = 1;
                    int rCount = 1;
                    while (left + 1 < right && nums2[left] == nums2[left + 1]) {
                        lCount++;
                        left++;
                    }
                    while (right - 1 > left && nums2[left] == nums2[left - 1]) {
                        rCount++;
                        right--;
                    }
                    current += lCount * rCount;
                    left++;
                    right--;
                }
            }
            ans += current;
        }
        return ans;
    }
}
