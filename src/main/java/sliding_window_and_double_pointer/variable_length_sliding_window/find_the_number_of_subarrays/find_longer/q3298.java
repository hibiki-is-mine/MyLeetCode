package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3298. 统计重新排列后包含另一个字符串的子字符串数目 II
 * <p>
 * 给你两个字符串 word1 和 word2 。
 * <p>
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的
 * <p>
 * 前缀
 * <p>
 * ，那么我们称字符串 x 是 合法的 。
 * <p>
 * 请你返回 word1 中 合法
 * <p>
 * 子字符串
 * <p>
 * 的数目。
 * <p>
 * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
 *
 * @author cyj
 * @date 2024/12/13
 */
public class q3298 {
    @Test
    public void test(){
        String word1 = "bcca";
        String word2 = "abc";
        System.out.println(validSubstringCount(word1, word2));
    }

    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()){
            return 0L;
        }
        int currentLen = 0;
        int targetLen = 0;
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            int n = word2Array[i] - 'a';
            if (count2[n] == 0){
                targetLen++;
            }
            count2[n]++;
        }
        int left = 0;
        int right = 0;
        long result = 0;

        while (right < word1.length()){
            int m = word1Array[right] -'a';
            count1[m]++;
            if (count1[m] == count2[m]){
                currentLen++;
            }
            while (currentLen == targetLen){
                result += word1.length() - right;
                int n = word1Array[left] - 'a';
                count1[n]--;
                if (count1[n] < count2[n]){
                    currentLen--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
