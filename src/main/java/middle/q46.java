package middle;

import org.junit.Test;

import java.util.*;

/**
 * @author Ego
 */
public class q46 {
    @Test
    public void test(){
        int[] nums = {3,3,0,3};
        List<List<Integer>> permute = permuteUnique(nums);
        permute.forEach(System.out::println);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used =  new boolean[nums.length];

        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(),used ,nums);
        return result;
    }
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length;i++) {
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i-1] == nums[i] && !used[i -1]){
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList,used,nums);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
    private Map<Integer, Integer> countMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map;
    }
}
