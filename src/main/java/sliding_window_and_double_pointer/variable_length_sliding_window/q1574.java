package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 * <p>
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q1574 {
    @Test
    public void test(){
        int[] arr = {1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        return 1;
    }
}
