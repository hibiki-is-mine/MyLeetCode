package simple;

import org.junit.Test;

public class q231 {
    @Test
    public void test(){
        int n = -2147483648;
        System.out.println(isPowerOfTwo(n));
    }
    public boolean isPowerOfTwo(int n) {
        if (n == 1){
            return true;
        }
        if(n % 2 == 1 || n <= 0){
            return false;
        }
        char[] array = Integer.toBinaryString(n).toCharArray();
        for (int i = 1; i < array.length;i ++){
            if (array[i] != '0'){
                return false;
            }
        }
        return true;
    }
}
