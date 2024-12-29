package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

/**
 * 1750. 删除字符串两端相同字符后的最短长度
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 * @author cyj
 * @date 2024/12/18
 */
public class q1750 {
    @Test
    public void test(){
        String  s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLength(s));
    }
    public int minimumLength(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while  (charArray[left] == charArray[right]){
            if (left == right){
                return 1;
            }
            do {
                left++;
            } while (charArray[left] == charArray[left - 1] && left < right);
            do {
                right--;
            } while (charArray[right] == charArray[right + 1] && left < right);
            if (left > right){
                return 0;
            }

        }

        return right - left + 1;

    }
}

