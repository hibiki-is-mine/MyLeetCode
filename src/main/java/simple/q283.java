package simple;

import org.junit.Test;

public class q283 {
    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0;i < nums.length;i ++){
            System.out.println(nums[i]);
        }
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
