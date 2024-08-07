package middle;

import org.junit.Test;

/**
 *
 * 55. 跳跃游戏
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * @author cyj
 * @date 2024/07/06
 */
public class q55 {

    @Test
    public void test(){
        int[] nums = {2,0};
        System.out.println(canJump1(nums));
    }

    /**
     * 使用类似 n皇后的递归解法
     * 可以求出能够到达终点的所有的路径
     *
     * @param nums
     * @return boolean
     */
    public boolean canJump1(int[] nums) {
        if (nums.length == 1 && nums[0] == 0){
            return true;
        }
        return jump(nums,0);
    }

    public boolean jump(int[] nums,int index){
        if (index == nums.length-1){
            return true;
        }
        if (index >= nums.length){
            return false;
        }
        if (nums[index] == 0){
            return false;
        }

        int current = nums[index];
        for (int i = current; i >= 1; i--){
            if (jump(nums,index+i)){
                return true;
            }
        }
        return false;
    }


    /**
     * 贪心算法，维护一个当前能够到达的最大距离 max
     *
     * 遍历数组
     * 每次 max 更新为当前能够到达的最大距离，即当前下标 i+当前下标的数字nums[i]
     * 当 max 超过nums.length-1时，返回true
     * 当 i>max时，即当前下标超出当前能够到达的最大距离，说明无法到达最后一个位置，返回false
     *
     * @param nums
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > max){
                return false;
            }
            max = Math.max(max,i+nums[i]);
            if (max >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
