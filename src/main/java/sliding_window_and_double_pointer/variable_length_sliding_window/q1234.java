package sliding_window_and_double_pointer.variable_length_sliding_window;

/**
 * 1234. 替换子串得到平衡字符串
 * <p>
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q1234 {
    public int balancedString(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        int min = 0;
        for (char c : charArray){
            count[c - 'A']++;
        }
        int target = charArray.length / 4;
        if (count['Q' - 'A'] == target && count['W' - 'A'] == target && count['E' - 'A'] == target && count['R' - 'A'] == target){
            return 0;
        }
        int left = 0;
        int right = 0;

        return  1;

    }
}
