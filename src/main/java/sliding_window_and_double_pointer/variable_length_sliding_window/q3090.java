package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 * <p>
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该
 * <p>
 * 子字符串的最大长度。
 *
 * @author cyj
 * @date 2024/12/05
 */
public class q3090 {
    @Test
    public void test(){
        String s = "bcbbbcba";
        int i = maximumLengthSubstring(s);
        System.out.println(i);
    }


    public int maximumLengthSubstring(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        int max = 0;
        int current = 0;
        for (int i = 0; i < charArray.length; i++){
            int index = charArray[i] - 'a';
            count[index]++;
            current++;
            if (count[index] > 2){
                while (count[index] > 2){
                    count[charArray[i - current+1] - 'a']--;
                    current--;

                }
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
