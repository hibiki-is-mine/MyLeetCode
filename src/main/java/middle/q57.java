package middle;

import common.ArraysUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 57. 插入区间
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 * @author cyj
 * @date 2024/09/30
 */
public class q57 {

    @Test
    public void test(){
        int[][] intervals = ArraysUtil.formatArray("[[1,2],[3,5],[6,7],[8,10],[12,16],[17,18]]");
        int[] newInterval = new int[]{4,8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res =new int[intervals.length][2];
        int index = 0;
        boolean inserted = false;
        int[] pre = newInterval;
        for (int[] cur : intervals) {
            if (newInterval[0] <= cur[1] && newInterval[1] >= cur[0]) {
                inserted = true;
                pre[0] = Math.min(pre[0], cur[0]);
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                if (!inserted) {
                    pre = cur;
                }
                res[index++] = new int[]{pre[0], pre[1]};
                pre = new int[]{newInterval[0], newInterval[1]};
            }
        }
        res[index++] = intervals[intervals.length-1];
        return Arrays.copyOf(res, index);
    }
}
