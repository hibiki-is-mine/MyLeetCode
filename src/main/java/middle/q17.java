package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q17 {
    @Test
    public void test(){
        String digits = "23";
        letterCombinations(digits).forEach(System.out::println);
    }
    public List<String> letterCombinations(String digits) {

        String[] letters ={"", "", "abc", "def", "ghi", "jkr", "mno", "pqrs", "tuv", "wxyz"};
        List<String> strings = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()){
            return null;
        }
        for (int i = 0;i < digits.length();i++){
            int digit = digits.charAt(i) -'0';
            strings.add(letters[digit]);
        }
        combine(ans, strings, 0, "");
        return ans;
    }
    public void combine(List<String> ans, List<String> strings, int index, String current){
        if (index == strings.size()){
            ans.add(current);
        }else {
            for (char c : strings.get(index).toCharArray()){
                combine(ans, strings, index+1, current + c);
            }
        }
    }
}
