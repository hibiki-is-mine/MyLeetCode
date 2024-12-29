package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 948. 令牌放置
 * 你的初始 能量 为 power，初始 分数 为 0，只有一包令牌以整数数组 tokens 给出。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 * 你的目标是通过有策略地使用这些令牌以 最大化 总 分数。在一次行动中，你可以用两种方式中的一种来使用一个 未被使用的 令牌（但不是对同一个令牌使用两种方式）：
 * 朝上：如果你当前 至少 有 tokens[i] 点 能量 ，可以使用令牌 i ，失去 tokens[i] 点 能量 ，并得到 1 分 。
 * 朝下：如果你当前至少有 1 分 ，可以使用令牌 i ，获得 tokens[i] 点 能量 ，并失去 1 分 。
 * 在使用 任意 数量的令牌后，返回我们可以得到的最大 分数 。
 *
 * @author cyj
 * @date 2024/12/20
 */
public class q948 {
    @Test
    public void test(){
        int[] tokens = {26};
        int power = 51;
        System.out.println(bagOfTokensScore(tokens,power));
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 1){
            return power>=tokens[0]?1:0;
        }
        Arrays.sort(tokens);
        int max = 0;
        int point = 0;
        int left = 0;
        int right = tokens.length - 1;
        while(left < right && point >= 0){
            while (left< tokens.length && tokens[left] <= power){
                power -= tokens[left];
                point++;
                max = Math.max(max,point);
                left++;
            }
            power += tokens[right];
            right--;
            point--;
        }
        return max;
    }
}
