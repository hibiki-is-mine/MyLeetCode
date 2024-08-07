package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q16 {
    @Test
    public void test(){
        int[] nums = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        int threeSumClosest = threeSumClosest(nums, -14);
        System.out.println(threeSumClosest);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target){
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if (sum > target){
                    right--;
                   /* while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }*/
                } else {
                    left++;
                    /*while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }*/
                }
            }
        }
        return best;
    }
}
