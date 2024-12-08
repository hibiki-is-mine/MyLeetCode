package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 *
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 * @author cyj
 * @date 2024/12/04
 */
public class q1297 {
    @Test
    public void test(){
        String s = "aabcabcab";
        int maxLetters = 2;
        int minSize = 2;
        int maxSize = 3;
        int i = maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println(i);
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> stringCount = new HashMap<>();
        int[] count = new int[26];
        int countSize = 0;
        String current;
        for (int i = 0; i < s.length();i++){
            int rightIndex = s.charAt(i) - 'a';
            if (count[rightIndex] == 0){
                countSize++;
            }
            count[rightIndex]++;

            if (i + 1 >= minSize){
                if (countSize <= maxLetters){
                    current = s.substring(i- minSize +1, i+1);
                    stringCount.put(current, stringCount.getOrDefault(current, 0)+1);
                }
                int leftIndex = s.charAt(i- minSize +1) -'a';
                if (count[leftIndex] == 1){
                    countSize--;
                }
                count[leftIndex]--;
            }
        }

        return stringCount.values().stream().max(Integer::compareTo).orElse(0);
    }
}
