package sliding_window_and_double_pointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2841. 几乎唯一子数组的最大和
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 *
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 *
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 *
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 *
 * @author cyj
 * @date 2024/11/28
 */
public class q2841 {

    @Test
    void test(){
        int[] arr = new int[]{2,6,7,3,1,7};

        List<Integer> nums= Arrays.stream(arr).boxed().collect(Collectors.toList());
        int m = 3;
        int k = 4;
        System.out.println(maxSum(nums, m, k));
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        Integer[] arr = nums.toArray(new Integer[0]);
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.size(); i++){
            int right = arr[i];
            if (i < k){
                map.put(right, map.getOrDefault(right, 0)+1);
                currentSum += right;
            } else {
                int left = arr[i-k];
                currentSum += right;
                currentSum -= left;
                map.put(right, map.getOrDefault(right, 0)+1);
                if (map.get(left) == 1){
                    map.remove(left);
                } else {
                    map.put(left, map.get(left)-1);
                }
            }
            if (map.size() >= m && i >= k-1){
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }
}
