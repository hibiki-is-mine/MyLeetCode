package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 2516. 每种字符至少取 K 个
 * <p>
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * <p>
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q2516 {
    @Test
    public void test(){
        String s = "a";
        int k = 1;
        System.out.println(takeCharacters(s,k));
    }

    public int takeCharacters(String s, int k) {
        if (k == 0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int[] count = new int[3];
        int left = 0;
        int right =0;
        int max = 0;
        for (char c : charArray) {
            count[c - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k){
            return -1;
        }
        while(right < charArray.length){
            count[charArray[right] - 'a']--;
            while (count[charArray[right] - 'a'] < k) {
                count[charArray[left] - 'a']++;
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return charArray.length - max;
    }
}
