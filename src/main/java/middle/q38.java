package middle;

import org.junit.Test;

public class q38 {

    @Test
    public void test() {
        System.out.println(countAndSay(4));
    }

    public String countAndSay(int n) {
        return CountAndSay(n);
    }


    private String CountAndSay(int n){
        if (n == 1) {
            return "1";
        } else {
            return getCountAndSay(CountAndSay(n-1));
        }
    }
    public String getCountAndSay(String n) {
        char[] chars = n.toCharArray();
        char target = chars[0];
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == target) {
                count++;
            } else {
                result.append(count).append(target);
                target = aChar;
                count = 1;
            }
        }
        result.append(count).append(target);
        return result.toString();
    }


}
