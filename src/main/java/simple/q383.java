package simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q383 {
    @Test
    public void test(){
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character ,Integer> map = new HashMap<>();
        for (int i = 0;i < magazine.length();i++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0;i < ransomNote.length();i++){
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) != 0){
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }else {
                return false;
            }
        }
        return true;
    }
}
