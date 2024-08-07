package simple;

import org.junit.Test;

public class q70 {
    @Test
    public void test(){
        System.out.println(climbStairs(5));
    }

    public int climbStairs(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] d = new int[n];
        d[0]=1;
        d[1]=2;
        for (int i = 0;i < n-2;i++){
            d[i+2] = d[i] + d[i+1];
        }
        return d[n-1];
    }
}
