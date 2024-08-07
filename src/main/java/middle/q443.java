package middle;

import org.junit.Test;

/**
 * @author cyj
 * @date 2024/07/05
 */
public class q443 {

    @Test
    public void test(){
        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;
        int count = 0;
        char target = chars[0];
        for (char ch : chars){
            if (ch == target){
                count++;
            }else {
                writeIndex = fillChars(chars,target,writeIndex,count);
                readIndex = readIndex + count;
                target = ch;
                count = 1;
            }
            readIndex++;
        }
        writeIndex = fillChars(chars,target,writeIndex,count);
        return writeIndex;
    }
    private int fillChars(char[] chars, char target,int writeIndex,int count){
        chars[writeIndex] = target;
        if (count == 1) {
            writeIndex ++;
        } else if (count <= 9){
            chars[writeIndex + 1] = (char)(count + '0');
            writeIndex += 2;
        } else {
            int length = (int) (Math.log10(count)) + 1;
            for (int i = length; i > 0; i--){
                chars[writeIndex +i] = (char)(count % 10 +'0');
                count = count / 10;
            }
            writeIndex += length + 1;
        }
        return writeIndex;
    }

}
