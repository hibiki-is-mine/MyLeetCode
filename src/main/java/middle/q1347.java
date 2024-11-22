package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1347. 制造字母异位词的最小步骤数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 *
 * @author cyj
 * @date 2024/09/30
 */
public class q1347 {

    @Test
    public void test(){
        String s = "leetcode";
        String t = "practice";

        System.out.println(minSteps(s, t));

    }

    public int minSteps(String s, String t) {
        int step = 0;
        Map<Character, Integer> sMap = new HashMap<>(s.length());
        Map<Character, Integer> tMap = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character key : sMap.keySet()){
            if (tMap.containsKey(key)){
                step += Math.abs(sMap.get(key) - tMap.get(key));
            } else  {
                step+= sMap.get(key)/2;
            }
        }
        return step;
    }
}
