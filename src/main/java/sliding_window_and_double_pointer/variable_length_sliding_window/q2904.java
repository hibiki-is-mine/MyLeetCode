package sliding_window_and_double_pointer.variable_length_sliding_window;

import org.junit.Test;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 * <p>
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * <p>
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * <p>
 * 令 len 等于 最短 美丽子字符串的长度。
 * <p>
 * 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * <p>
 * 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
 * <p>
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 *
 * @author cyj
 * @date 2024/12/10
 */
public class q2904 {
    @Test
    public void test(){
        String s = "110101000010110101";
        int k = 3;
        System.out.println(shortestBeautifulSubstring(s,k));
    }
    @Test
    public void test2(){
        String s= "1100001110111";
        System.out.println(Integer.parseInt(s, 2));
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int[] count = new int[2];
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            if (c == '1'){
                count[1]++;
            } else {
                count[0]++;
            }
            while (count[1] >= k){

                while (s.charAt(left) == '0'){
                    count[0]--;
                    left++;
                }
                if (right - left + 1 < min){
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                } else if (right - left + 1 == min && s.substring(left, right + 1).compareTo(result) < 0){
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (leftChar == '1'){
                    count[1]--;
                } else {
                    count[0]--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
