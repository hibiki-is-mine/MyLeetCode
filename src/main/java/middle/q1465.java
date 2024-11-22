package middle;

import java.util.Arrays;

/**
 *
 * 1465. 切割后面积最大的蛋糕
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 * horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
 *
 * @author cyj
 * @date 2024/09/30
 */
public class q1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(h - horizontalCuts[horizontalCuts.length - 1], horizontalCuts[0]);
        int maxW = Math.max(w - verticalCuts[verticalCuts.length - 1], verticalCuts[0]);
        for(int i=1;i<horizontalCuts.length;i++){
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for (int i=1;i<verticalCuts.length;i++){
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i-1]);
        }
        return (int)((long)maxH * maxW % 1000000007);
    }
}
