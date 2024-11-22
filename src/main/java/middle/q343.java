package middle;

/**
 *
 * 343. 整数拆分
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * @author cyj
 * @date 2024/09/30
 */
public class q343 {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int product = 1;
        while (n > 4) {
            // 拆分出3
            product *= 3;
            n -= 3;
        }

        // 处理剩下的部分
        product *= n;
        return product;
    }
}
