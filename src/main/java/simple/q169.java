package simple;

import java.util.HashMap;
import java.util.Map;

public class q169 {
    public int majorityElement(int[] nums) {
        int times = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
              map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > times){
                return entry.getKey();
            }
        }
        return 0;
    }
}
