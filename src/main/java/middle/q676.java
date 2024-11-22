package middle;

import org.junit.Test;

/**
 * @author cyj
 * @date 2024/08/12
 */
public class q676 {

    class MagicDictionary {

        private String[] dict;

        public MagicDictionary() {
        }

        public void buildDict(String[] dictionary) {
            dict = dictionary;
        }

        public boolean search(String searchWord) {
            int diff;

            for (String s : dict){
                if (s.length() != searchWord.length()) {
                    continue;
                }
                diff = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1){
                       break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void test(){
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode","judge"});

        System.out.println(magicDictionary.search("juage"));
    }
}
