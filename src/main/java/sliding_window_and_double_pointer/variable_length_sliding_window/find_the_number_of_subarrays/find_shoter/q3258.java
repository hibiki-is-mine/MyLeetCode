package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_shoter;

/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 * <p>
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * <p>
 * 字符串中 1 的数量最多为 k。
 * <p>
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 *
 * @author cyj
 * @date 2024/12/16
 */
public class q3258 {
    public int countKConstraintSubstrings(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] count = new int[2];
        int right = 0;
        int left = 0;
        int ans = 0;
        while (right < charArray.length){
            count[charArray[right] - 'a']++;
            while(count[0] > k && count[1] > k){
                count[charArray[left] - 'a']--;
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
