package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class q12 {
    @Test
    public void test(){
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
    }
    public String intToRoman(int num){
        Map<Integer, String> romanNumerals = new HashMap<>(7);

        romanNumerals.put(1, "I");
        romanNumerals.put(5, "V");
        romanNumerals.put(10, "X");
        romanNumerals.put(50, "L");
        romanNumerals.put(100, "C");
        romanNumerals.put(500, "D");
        romanNumerals.put(1000, "M");

        StringBuilder stringBuilder = new StringBuilder(4);
        for (int i = 3; i >= 0;i--){
            int digit = (int) Math.pow(10, i);
            int pre = num / digit;
            int max = pre * digit;
            while (pre > 0){
                if (pre == 9){
                    stringBuilder.append(romanNumerals.get(digit)).append(romanNumerals.get(10 * digit));
                    break;
                } else if (pre >= 5){
                    stringBuilder.append(romanNumerals.get(5 * digit));
                    pre -= 5;
                } else if (pre == 4) {
                    stringBuilder.append(romanNumerals.get(digit)).append(romanNumerals.get(5 * digit));
                    break;
                } else {
                    stringBuilder.append(romanNumerals.get(digit));
                    pre --;
                }
            }
            num -= max;
        }
        return stringBuilder.toString();
    }
}
