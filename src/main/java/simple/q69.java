package simple;

import org.junit.Test;

public class q69 {
    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        int ans = 1;
        int low = 0;
        int high = x;

        while (low <= high){
            int middle =(low + high) / 2;
            if ( middle * middle <= x){
                ans = middle;
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return ans;
    }
}
