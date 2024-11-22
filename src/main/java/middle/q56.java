package middle;

import common.ArraysUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 56. 合并区间
 * 中等
 * 相关标签
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author cyj
 * @date 2024/09/30
 */
public class q56 {

    @Test
    public void test(){
        //int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] intervals = ArraysUtil.formatArray("[[5,5],[1,3],[3,5],[4,6],[1,1],[3,3],[5,6],[3,3],[2,4],[0,0]]");
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            int[] pre = intervals[0];
            // 原地操作节省空间：已经确定的区间，直接存储在intervals的前面，k记录序号。
            int k = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] cur  = intervals[i];
                if(cur[0] <= pre[1]){
                    // 当前区间的左边界小于前一个区间的右边界时，可以合并，用pre记录
                    int e = Math.max(pre[1], cur[1]);
                    pre = new int[]{pre[0], e};
                } else {
                    // 和前一个不能合并时，将pre记录在intervals的前面，更新pre为cur
                    intervals[k++] = pre;
                    pre = cur;
                }
            }
            // 记录最后一个区间
            intervals[k++] = pre;
            // 对intervals截断，只取前面的结果部分
            return Arrays.copyOfRange(intervals,0, k);
        }

}
