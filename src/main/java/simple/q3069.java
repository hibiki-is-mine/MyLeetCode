package simple;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 3069. 将元素分配到两个数组中 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。
 *
 * 你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 *
 * 如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
 * 通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 *
 * 返回数组 result 。
 *
 * @author cyj
 * @date 2024/06/05
 */
public class q3069 {

    @Test
    public void test(){
        int[] nums = {2,1,3};
        int[] ints = resultArray2(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];

        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int arr1Num = 1;
        int arr2Num = 1;
        int count = 2;
        while (count < nums.length){
            if (arr1[arr1Num-1] > arr2[arr2Num-1]){
                arr1[arr1Num] = nums[count];
                arr1Num++;
            }else {
                arr2[arr2Num] = nums[count];
                arr2Num++;
            }
            count++;
        }
        int[] mergedArray = new int[nums.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1Num);
        System.arraycopy(arr2, 0, mergedArray, arr1Num, arr2Num);
        return mergedArray;
    }

    public int[] resultArray2(int[] nums) {
        List<Integer> arr1 = new ArrayList<>(nums.length/2);
        List<Integer> arr2 = new ArrayList<>(nums.length/2);
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int count = 2;
        while (count < nums.length){
            if (arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(nums[count]);
            }else {
                arr2.add(nums[count]);
            }
            count++;
        }
        arr1.addAll(arr2);
        return arr1.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    public void bigDecimalTest() {
        BigDecimal b1 = new BigDecimal("100.00");
        BigDecimal b2 = new BigDecimal("100.0");
        System.out.println(Objects.equals(b1, b2));
    }

    @Test
    public void test2() {
        String data = "Fri Jun 28 10:03:03 CST 2024";
        System.out.println(dateFormatConversion(data));

    }
    private String dateFormatConversion(String dateStr) {
        String formattedDate = "";
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+8")); // 假设CST为UTC+8
            Date date = inputFormat.parse(dateStr);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formattedDate = outputFormat.format(date);
        } catch (ParseException ignored) {

        }
        return formattedDate;
    }
}
