package middle;

import org.junit.Test;

/**
 * @author cyj
 * @date 2024/08/07
 */
public class q3115 {
    @Test
    public void test(){
        int[] nums = {2,2};
        System.out.println(maximumPrimeDifference(nums));
    }
    public int maximumPrimeDifference(int[] nums) {
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < nums.length; i++){
            if (isPrime(nums[i])){
                    leftIndex = i;
                    break;
            }
        }
        for (int i = nums.length-1; i >= 0 ; i--){
            if (isPrime(nums[i])){
                rightIndex = i;
                break;
            }
        }
        return Math.max(rightIndex - leftIndex, 0);
    }

    private boolean isPrime(int num) {
        if (num < 2){
            return false;
        }
        if (num == 2){
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
