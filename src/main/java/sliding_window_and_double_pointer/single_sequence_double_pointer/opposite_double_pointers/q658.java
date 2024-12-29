package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * @author cyj
 * @date 2024/12/18
 */
public class q658 {
    @Test
    public void test(){
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        List<Integer> integers = findClosestElements(arr, k, x);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int start;
        int end;
        while (right - left + 1 > k){
            start = Math.abs(arr[left] - x);
            end =  Math.abs(arr[right] - x);
            if (start > end){
                left++;
            } else {
                right--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
