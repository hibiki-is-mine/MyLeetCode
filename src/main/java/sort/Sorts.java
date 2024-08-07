package sort;

import cn.hutool.core.lang.tree.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * The type Sorts.
 */
public class Sorts {
    /**
     * Test.
     */
    @Test
    public void test(){
        int[] ints = {4,251,515,64,21,1,56,3,-1,9,68,-789};
        quickSort(ints, 0, ints.length-1);
        for (int i : ints){
            System.out.println(i);
        }
    }

    /**
     * Bubble sort int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public static int[] bubbleSort(int[] nums){
        int[] ints = Arrays.copyOf(nums, nums.length);

        for (int i = 1;i < nums.length;i++){
            for (int j= 0; j < nums.length-i;j++){
                if (ints[j]>ints[j+1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
        return ints;
    }

    /**
     * Selection sort int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public static int[] selectionSort(int[] nums){
        for (int i = 0;i< nums.length;i++){
            int minIndex = i;
            for (int j = i+1;j< nums.length;j++){
                if (nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            int temp = 0;
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    /**
     * Insert sort int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public static int[] insertSort(int[] nums){
        for (int i = 1;i < nums.length;i++ ){
            for (int j = 0;j <= i;j++){
                if (nums[i]<nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 首先选择数组中第一个数作为基准(base = nums[left])
     * 当左下标小于右下标的时候
     * 首先从右向左遍历，如果发现比基准小的数，替换left下标对应的数
     * 再从左向右遍历，如果发现比基准大的数，替换right下标对应的数
     * 直到两个下标重合，将base赋值给当前下标
     * 此时以base为分界线，将数组分割成两部分，左边部分都比base小，右边部分都比base大
     * 对这两部分分别执行上述操作，不断递归直到传入的左右下标相等，此时完成排序
     *
     * @param nums  the nums
     * @param start the start
     * @param end   the end
     */
    public static void quickSort(int[] nums, int start, int end){
        if (start<end){
            int left = start;
            int right = end;
            int base = nums[left];
            while (left<right){
                while (left<right && nums[right] >= base){
                    right--;
                }
                nums[left] = nums[right];
                while (left<right && nums[left] <= base){
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = base;

            quickSort(nums, start, left-1);
            quickSort(nums, left+1, end);
        }
    }

}
