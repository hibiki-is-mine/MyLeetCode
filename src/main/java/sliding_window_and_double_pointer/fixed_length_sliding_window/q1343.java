package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * @author cyj
 * @date 2024/11/22
 */
public class q1343 {
    @Test
    public void test(){
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int target = k * threshold;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < k; i++){
            sum += arr[i];
        }
        if (sum >= target){
            count++;
        }
        for (int i = k; i< arr.length; i++){
            sum -= arr[i -k];
            sum += arr[i];
            if (sum >= target){
                count++;
            }
        }
        return count;
    }

}
