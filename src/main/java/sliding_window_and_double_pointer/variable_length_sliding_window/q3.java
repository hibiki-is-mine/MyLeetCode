package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author cyj
 * @date 2024/12/05
 */
public class q3 {
    @Test
    public void test(){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        int max = 0;
        int current = 0;
        for (int i = 0; i < charArray.length; i++){
            if (set.contains(charArray[i])){
                while (set.contains(charArray[i])){
                    set.remove(charArray[i - current]);
                    current--;
                }
            }
            set.add(charArray[i]);
            current++;
            max = Math.max(max, current);
        }
        return max;
    }
}
