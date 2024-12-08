package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 2730. 找到最长的半重复子字符串
 * <p>
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * <p>
 * <p>
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。
 * <p>
 * <p>
 * 请你返回 s 中最长 半重复子字符串的长度。
 *
 * @author cyj
 * @date 2024/12/05
 */
public class q2730 {
    @Test
    public void test(){
        String s= "1111111";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }

    public int longestSemiRepetitiveSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 1){
            return 1;
        }
        int repeatCount = 0;
        int repeatIndex = 0;
        int current = 1;
        int max = 0;
        for(int i = 1; i < s.length(); i++){
            current++;
            if (charArray[i] == charArray[i - 1]){
                repeatCount++;
                repeatIndex = repeatIndex == 0 ? i : repeatIndex;
            }
            if (repeatCount > 1){
                repeatCount --;
                current = i - repeatIndex + 1;
                repeatIndex = i;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
