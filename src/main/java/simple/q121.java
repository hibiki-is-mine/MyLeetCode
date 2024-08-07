package simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class q121 {
    @Test
    public void test(){
        int[] nums = {1,6,2,2,4};
        int i = maxProfit2(nums);
        System.out.println(i);
    }
    public int maxProfit(int[] prices){

        HashSet<Integer> set = new HashSet<>(prices.length);
        int minIndex = 0;
        int min;
        int maxPrice = 0;

        for (int j =0;j < prices.length-1;j++){
            min = Integer.MAX_VALUE;
            for (int i = 0;i < prices.length;i++){
                if (set.contains(i)){
                    continue;
                }
                if (prices[i] < min ){
                    min = prices[i];
                    minIndex = i;
                }
            }
            set.add(minIndex);
            for (int i = minIndex; i < prices.length;i++){
                if (prices[i]-min > maxPrice){
                    maxPrice = prices[i]-min;
                }
            }
        }
        return Math.max(maxPrice, 0);

    }

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
