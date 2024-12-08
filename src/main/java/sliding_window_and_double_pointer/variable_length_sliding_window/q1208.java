package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 1208. 尽可能使字符串相等
 * <p>
 * <p>
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * @author cyj
 * @date 2024/12/05
 */
public class q1208 {

    @Test
    public void test(){
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] cost = new int[chars.length];
        int costSum = 0;
        int current = 0;
        int max = 0;
        for (int i = 0 ; i < chars.length; i++){
            cost[i] = Math.abs(chars[i] - chart[i]);
            costSum += cost[i];
            current++;
            while (costSum > maxCost){
                costSum -= cost[i - current + 1];
                current--;
            }
            max = Math.max(max, current);
        }

        return max;
    }
}
