package middle;

import org.junit.Test;

import java.util.Arrays;

/**
 *1845. 座位预约管理系统
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
 * 请你实现 SeatManager 类：
 * SeatManaerve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 * void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 *
 *
 *
 * @authorger(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
 *  * int res cyj
 * @date 2024/09/30
 */
public class q1845 {


    class SeatManager {

        private final boolean[] seat;
        private int index;
        private int availableSeatNum;
        public SeatManager(int n) {
            this.seat= new boolean[n];
        }

        public int reserve() {
           if (seat[index]){
               seat[index] = false;
               return ++index;
           } else {
               while (!seat[index]){
                   index++;
               }
           }
            seat[index] = false;
            return ++index;
        }

        public void unreserve(int seatNumber) {
            seat[seatNumber-1] = true;
            index = Math.min(index, seatNumber-1);
        }
    }
    @Test
    public void test(){
        SeatManager seatManager = new SeatManager(5); // 初始化 5 个座位
        System.out.println(seatManager.reserve()); // 输出：1 ，第 1 个座位被预约，所以返回 1
        System.out.println(seatManager.reserve()); // 输出：2 ，第 2 个座位被预约，所以返回 2
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2); // 将座位 2 变为可以预约，
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }

}
