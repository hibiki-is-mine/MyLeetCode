package simple;

import org.junit.Test;

/**
 *
 * 2073. 买票需要的时间
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 *
 * @author cyj
 * @date 2024/09/29
 */
public class q2073 {

    @Test
    public void test(){
        int[] tickets = {2,3,2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        while (true){
            for (int i = 0; i < tickets.length; i++){
                if (tickets[i] == 0){
                    continue;
                }
                if (i == k && tickets[i] == 1){
                    return totalTime + 1;
                }
                totalTime++;
                tickets[i]--;
            }
        }
    }


}
