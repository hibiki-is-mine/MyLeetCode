package simple;

import org.junit.Test;

/**
 *
 * 191. 位1的个数
 * 简单
 * 相关标签
 * 相关企业
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 * @author cyj
 * @date 2024/06/02
 */
public class q191 {

    @Test
    public void test(){
        int i = hammingWeight(128);
        System.out.println(i);
    }
    public int hammingWeight(int n) {
        int count = 0;

        while (n!=0){
            n &= n - 1;
           count++;
        }
       return count;
    }
}
