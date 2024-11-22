package middle;

import org.junit.Test;

import java.util.*;

/**
 * @author cyj
 * @date 2024/01/31
 */
public class q39 {
    @Test
    public void test(){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = combinationSum(candidates, target);
        list.forEach(System.out::println);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack2(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> tempList,int index, int[] candidates, int target){
        int sum = tempList.stream().reduce(0, Integer::sum);
        if (sum == target){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index;i < candidates.length;i++){
            if (sum + candidates[i] > target){
                return;
            }
            tempList.add(candidates[i]);
            backtrack(ans, tempList, i, candidates, target);
            tempList.remove(tempList.size() - 1);
        }
    }
    private void backtrack2(List<List<Integer>> ans, List<Integer> tempList, int index, int[] candidates, int target){
        if (target == 0){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index;i < candidates.length;i++){
            if (target - candidates[i] < 0){
                break;
            }
            //同一层中，对于该层的第二个数开始的每个数，如果与前一个数相等，则跳过该此循环
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            tempList.add(candidates[i]);
            backtrack2(ans, tempList, i+1, candidates, target - candidates[i]);
            tempList.remove(tempList.size()-1);
        }
    }
}
