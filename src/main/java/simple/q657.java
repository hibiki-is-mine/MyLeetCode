package simple;

import org.junit.Test;

public class q657 {
    @Test
    public void test(){
    }

    public boolean judgeCircle(String moves) {
        int[]coordinate = new int[2];
        for (char c : moves.toCharArray()){
            switch (c){
                case 'U':
                    coordinate[0] ++;
                    break;
                case 'D':
                    coordinate[0] --;
                    break;
                case 'L':
                    coordinate[1] --;
                    break;
                case 'R':
                    coordinate[1] ++;
                    break;
                default:
            }
        }
        return coordinate[0] == 0 && coordinate[1] == 0;
    }
}
