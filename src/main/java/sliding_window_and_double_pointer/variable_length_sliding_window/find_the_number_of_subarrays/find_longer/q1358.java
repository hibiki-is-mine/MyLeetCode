package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

import org.junit.Test;

/**
 * 1358. 包含所有三种字符的子字符串数目
 * <p>
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目
 *
 * @author cyj
 * @date 2024/12/11
 */
public class q1358 {
    @Test
    public void test(){
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[3];
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < charArray.length){
            count[charArray[right] -'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){

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
