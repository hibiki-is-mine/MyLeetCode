package simple;

import org.junit.Test;

public class q168 {
    @Test
    public void test(){
        String s = convertToTitle(2147483647);
        System.out.println(s);
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber  != 0){
            int charNum =  (columnNumber - 1) % 26 + 1;
            char c = (char)(charNum + 64);
            stringBuilder.append(c);
            columnNumber = (columnNumber - charNum) / 26;
        }
        return stringBuilder.reverse().toString();

    }
}
