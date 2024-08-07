package simple;

public class q338 {
    public int[] countBits(int n) {
        int[] nums = new int[n];

        for (int i = 0;i <= n;i ++){
            nums[i] = Integer.bitCount(i);
        }
        return nums;
    }

}
