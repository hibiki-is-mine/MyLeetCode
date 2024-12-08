package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cyj
 * @date 2024/11/22
 */
public class q2090 {

    @Test
    public void test(){
        int[] nums = {4,9,1,8,2,6};
        int k = 3;
        int[] averages = getAverages(nums, k);
        for (int i : averages){
            System.out.println(i);
        }

    }

    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int range = 2 * k + 1;
        long sum = 0;
        if (range > nums.length){
            return ans;
        }

        for (int i = 0; i < range; i++){
            sum += nums[i];
        }
        ans[k] = (int) (sum / range);
        for (int i = k + 1 ;i < nums.length -k; i++){
            sum -= nums[i-k-1];
            sum += nums[i +k];
            ans[i] = (int) (sum/range);
        }
        return ans;
    }

}
