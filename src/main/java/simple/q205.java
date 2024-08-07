package simple;

import java.util.HashMap;
import java.util.Map;

public class q205 {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();

        //s2t将s中的字符作为key,t中字符作为value
        Map<Character, Character> s2t = new HashMap<>(len);
        //t2s将t中的字符作为key,s中字符作为value
        Map<Character, Character> t2s = new HashMap<>(len);

        for (int i = 0;i < len;i ++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if ((s2t.containsKey(charS) && s2t.get(charS) != charT) || (t2s.containsKey(charT) && t2s.get(charT) != charS)){
                return false;
            }
            s2t.put(charS, charT);
            t2s.put(charT, charS);
        }

        return true;
    }
}
