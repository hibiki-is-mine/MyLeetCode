package middle;

import org.junit.Test;

/**
 * @author cyj
 * @date 2024/07/07
 */
public class q1958 {

    @Test
    public void test(){
        char[][] charArray = {
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'}
        };
        System.out.println(checkMove(charArray, 4, 3, 'B'));
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char antiColor = color == 'B' ? 'W' : 'B';
        return searchLeft(board, rMove, cMove, color, antiColor);
    }

    private boolean searchLeft(char[][] board, int rMove, int cMove, char color, char antiColor){
        int antiCount = 0;
        for (int i = cMove-1; i >= 0; i--){
            if (board[rMove][i] == antiColor){
                antiCount++;
            }
            if (board[rMove][i] == color && antiCount > 0){
                return true;
            }
            if (board[rMove][i] == '.' || board[rMove][i] == color){
                return false;
            }
        }
        return false;
    }

}
