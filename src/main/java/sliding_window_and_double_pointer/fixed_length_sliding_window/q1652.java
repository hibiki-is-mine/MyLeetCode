package sliding_window_and_double_pointer.fixed_length_sliding_window;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * @author cyj
 * @date 2024/12/02
 */
public class q1652 {

//    输入：code = [2,4,9,3], k = -2
//输出：[12,5,6,13]
    @Test
    public void test(){
        int[] code = {2,4,9,3};
        int k = -2;
        int[] decrypt = decrypt(code, k);
        for (int i: decrypt){
            System.out.println(i);
        }
    }
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] ans = new int[len];
        if (k == 0){
            Arrays.fill(ans, 0);
            return ans;
        } else if (k > 0){
            int current = 0;
            for (int i = 1;i <= k;i++){
                current += code[i % len];
            }
            ans[0] = current;

            for (int i = 1;i <len;i++){
                current-= code[i % len];
                current+= code[(i+k) % len];
                ans[i] = current;
            }
            return ans;
        } else {
            int current = 0;
            int leftIndex =0;
            k = -k;
            for (int i = 1;i <= k;i++){
                current += code[len- (i % len)];
                leftIndex=len- (i % len);
            }
            ans[0] = current;
            for (int i = 1;i <len;i++){
                current -= code[leftIndex % len];
                current += code[(leftIndex + k) % len];
                ans[i] = current;
                leftIndex++;
            }
            return ans;
        }
    }
}
