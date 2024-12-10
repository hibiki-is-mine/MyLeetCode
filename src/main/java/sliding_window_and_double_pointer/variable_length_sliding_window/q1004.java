package sliding_window_and_double_pointer.variable_length_sliding_window;

/**
 *
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        while (right < nums.length){
            if (nums[right] == 0){
                count++;
            }
            while (count > k){
                if (nums[left] == 0){
                    count--;
                }
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}
