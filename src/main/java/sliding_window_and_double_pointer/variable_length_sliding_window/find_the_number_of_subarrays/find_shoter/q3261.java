package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_shoter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3261. 统计满足 K 约束的子字符串数量 II
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的 子字符串 的数量。
 *
 * @author cyj
 * @date 2024/12/16
 */
public class q3261 {
    @Test
    public void test(){
        String s = "010101";
        int k = 1;
        int[][] queries = {{0,5},{1,4},{2,3}};
        long[] longs = countKConstraintSubstrings(s, k, queries);
        for (long aLong : longs){
            System.out.println(aLong);
        }
    }
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++){
            if (map.containsKey(queries[i][0])){
                List<Integer> list = map.get(queries[i][0]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(queries[i][0], list);
            }
        }
        char[] charArray = s.toCharArray();
        int[] count = new int[2];
        long[] ans = new long[queries.length];
        int right = 0;
        int left = 0;
        while (right < charArray.length){
            count[charArray[right] - '0']++;
            while (count[0] > k && count[1] > k){
                count[charArray[left] - '0']--;
                left++;

            }
            for (int i = 0; i < queries.length; i++){
                int[] query = queries[i];
                if (left >= query[0] && right <= query[1]){
                    ans[i] += right - left + 1;
                }
            }

            right++;
        }
        return ans;
    }
}
