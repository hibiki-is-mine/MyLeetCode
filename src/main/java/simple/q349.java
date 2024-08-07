package simple;

import org.junit.Test;

import java.util.*;

public class q349 {
    @Test
    public void test(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums1){
            map.putIfAbsent(i,1);
        }
        for (int i : nums2){
            if (map.containsKey(i)){
                map.put(i,2);
                count++;
            }
        }
        int[] nums = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() >= 2){
                nums[i] = entry.getKey();
                i++;
            }
        }
        return nums;
    }
}
