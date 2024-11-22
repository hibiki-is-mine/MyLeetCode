package sliding_window_and_double_pointer;

import org.junit.Test;

/**
 *
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 *
 * @author cyj
 * @date 2024/11/22
 */
public class q643 {

    @Test
    public void test(){
        double d = findMaxAverage(new int[]{-1}, 1);
        System.out.println(d);
    }

    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            if (i >= k){
                sum -= nums[i-k];
            }
            sum += nums[i];
            if (i == k-1){
                max =sum ;
            } else{
                max = Math.max(sum , max);
            }

        }

        return (double)max/k;
    }
}
