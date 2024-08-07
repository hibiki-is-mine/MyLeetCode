package simple;

import java.util.Arrays;

public class q268 {
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0;i < nums.length;i ++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) {
        int arraySum = 0;
        int subSum = 0;
        for (int n : nums){
            arraySum += n;
        }
        for (int i = 0;i <= nums.length;i ++){
            subSum +=i;
        }
        return subSum - arraySum;
    }

}
