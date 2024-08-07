package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 51. N 皇后
 * 困难
 * 相关标签
 * 相关企业
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
 * @author cyj
 * @date 2024/07/07
 */
public class q51 {

    @Test
    public void test(){
        int n = 4;
        System.out.println(solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];//下标表示第几行，值表示第几列
        List<List<String>> strList = new ArrayList<>();
        placeQueen(arr,0,strList);


        return strList;
    }
    public void placeQueen(int[] arr, int row, List<List<String>> strList){
        int n = arr.length;
        if (row >= n){
            strList.add(saveQueen(arr));
            return;
        }
        for (int col = 0; col < n; col++){
            if (isValid(arr,row,col)){
                arr[row] = col;
                placeQueen(arr,row+1,strList);
            }
        }
    }

    private boolean isValid(int[] arr, int row, int col){
        for (int i = 0; i < row; i++){
            if (arr[i] == col || Math.abs(arr[i] - col) == Math.abs(i - row)){
                return false;
            }
        }
        return true;
    }

    private List<String> saveQueen(int[] arr){
        List<String> list = new ArrayList<>();
        for (int k : arr) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (k == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
