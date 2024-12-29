package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

/**
 * @author cyj
 * @date 2024/12/18
 */
public class q997 {
    @Test
    public void test(){
        int[] nums = {-4,-1,0,3,10};
        int[] ans = sortedSquares(nums);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int index = nums.length - 1; index >= 0; index --){
            int x = nums[left] * nums[left];
            int y = nums[right] * nums[right];
            if (x > y){
                ans[index] = x;
                left++;
            } else {
                ans[index] = y;
                right--;
            }
        }
        return ans;
    }
}
