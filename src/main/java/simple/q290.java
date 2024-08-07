package simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class q290 {
    @Test
    public void test(){
        String patter = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(patter, s));
    }
    public boolean wordPattern(String pattern, String s) {

        String[] strings = s.split(" ");
        if (pattern.length() != strings.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0;i < pattern.length();i ++){
            char c=  pattern.charAt(i);
            if (!map.containsKey(c) && !map.containsValue(strings[i])){
                map.put(pattern.charAt(i), strings[i]);
            } else if(!strings[i].equals(map.get(c))){
                return false;
            }
        }
        return true;
    }

}
