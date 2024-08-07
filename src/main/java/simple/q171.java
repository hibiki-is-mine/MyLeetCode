package simple;

import org.junit.Test;

public class q171 {
    public int titleToNumber(String columnTitle) {
        char[] charArray = columnTitle.toCharArray();
        int count = 0;
        for (char value : charArray) {
            int c = value - 64;
            count = count * 26 + c;
        }
        return count;
    }
    @Test
    public void test(){
        String columTitle  = "ZY";
        int number = titleToNumber(columTitle);
        System.out.println(number);
    }
}
