package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;


/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 * @author cyj
 * @date 2024/11/22
 */
public class q1456 {

    @Test
    public void test(){
        int i = maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33);
        System.out.println(i);
    }

    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();

        int max = 0;
        int current = 0;
        for (int i = 0; i < charArray.length; i++){
            if (i >= k) {
                if (isVowel(charArray[i - k])) {
                    current--;
                }
            }
            if (isVowel(charArray[i])){
                current ++;
            }
            max =Math.max(max, current);
        }

        return max;
    }

    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
