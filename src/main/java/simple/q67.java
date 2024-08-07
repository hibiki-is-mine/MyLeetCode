package simple;

import org.junit.Test;

/**
 * 67. 二进制求和
 * 简单
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class q67 {
    @Test
    public void test(){
        String a ="100";
        String b ="111";
        System.out.println(addBinary(a,b));
    }
    /*public String addBinary(String a, String b){
        int lenA = a.length();
        int lenB = b.length();

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        char[] arrayAns = new char[Math.max(lenA, lenB)];
        boolean up = false;
        for(int i = 0;i < arrayAns.length;i--){
            if (up){

            } else{
                if (arrayA[lenA-1-i] == '1' && arrayB[lenB-1-i] == '1'){
                    up =true;
                    arrayAns[arrayAns.length-1-i] = '0';
                } else if (arrayA[lenA-1-i] == '1' || arrayB[lenB-1-i] == '1') {

                }
            }


        }

    }*/
    /**
     *
     * 这个函数的作用是将两个二进制字符串相加，并返回它们的和。以下是代码的逐行解释：
     *
     * public static String addBinary(String a, String b)：这一行定义了一个名为addBinary的函数，它接受两个字符串类型的参数a和b，并返回一个字符串类型的结果。
     * StringBuilder sb = new StringBuilder();：这一行创建了一个名为sb的StringBuilder对象，用于构建结果字符串。
     * int i = a.length() - 1, j = b.length() - 1, carry = 0;：这一行定义了三个整型变量i、j和carry。其中，i和j分别表示输入字符串的最后一个字符的下标，而carry则用于存储进位。
     * while (i >= 0 || j >= 0)：这一行开始了一个while循环，只要输入字符串中还有字符没有处理完，就会继续执行循环体中的代码。
     * int sum = carry;：这一行定义了一个整型变量sum，并将其初始化为进位值。
     * if (i >= 0) sum += a.charAt(i--) - '0';：这一行判断输入字符串a是否还有字符没有处理完。如果有，则将当前字符转换为数字，并加上进位值。然后将下标向前移动一位。
     * if (j >= 0) sum += b.charAt(j--) - '0';：这一行与上一行类似，只不过是针对输入字符串b进行操作。
     * sb.append(sum % 2);：这一行将当前位的结果（即sum除以2的余数）添加到结果字符串中。
     * carry = sum / 2;：这一行计算出进位值（即sum除以2的商），并将其存储到变量carry中。
     * if (carry != 0) sb.append(carry);：这一行判断是否还有进位没有处理。如果有，则将进位值添加到结果字符串中。
     * return sb.reverse().toString();：这一行返回结果字符串。
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
