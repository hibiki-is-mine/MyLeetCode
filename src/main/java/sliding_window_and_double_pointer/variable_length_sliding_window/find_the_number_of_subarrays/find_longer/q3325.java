package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

/**
 * 3325. 字符至少出现 K 次的子字符串 I
 * <p>
 * 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
 * <p>
 * 子字符串 是字符串中的一个连续、 非空 的字符序列。
 * <p>
 * s 仅由小写英文字母组成。
 * @author cyj
 * @date 2024/12/11
 */
public class q3325 {
    @Test
    public void test(){
        String s = "abacb";
        int k = 2;
        System.out.println(numberOfSubstrings(s,k));
    }

    public int numberOfSubstrings(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        char maxChar = '1';
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < charArray.length) {
            count[charArray[right] - 'a']++;
           if (maxChar =='1' ||count[charArray[right] - 'a'] > count[maxChar - 'a']){
               maxChar = charArray[right];
           }
            while (count[maxChar - 'a'] >= k) {
                //当前窗口符合条件，则包含当窗口的剩余数组必定符合条件
                result += charArray.length - right;
                count[charArray[left] - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
