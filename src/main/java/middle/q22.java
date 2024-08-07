package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cyj
 * @date 2024/02/07
 */
public class q22 {

    @Test
    public void test(){
        int n = 4;
        List<String> list = generateParenthesis(n);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        ans.add("()");
        if (n == 1){
            return ans;
        }
        for (int i = 1; i < n;i++){
            Set<String> tempSet = new HashSet<>();
            for (String s : ans){
                tempSet.add("()" + s);
                tempSet.add(s + "()");
                tempSet.add("(" + s + ")");

            }
            ans.clear();
            ans.addAll(tempSet);
            if (i % 2 == 0 && i > 2){

            }
        }
    return ans;
    }
}
