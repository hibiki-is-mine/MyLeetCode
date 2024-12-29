package sliding_window_and_double_pointer.single_sequence_double_pointer.opposite_double_pointers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 923. 三数之和的多种可能
 * <p>
 * <p>
 * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
 * <p>
 * <p>
 * 由于结果会非常大，请返回 109 + 7 的模。
 *
 * @author cyj
 * @date 2024/12/20
 */
public class q923 {
    @Test
    public void test(){
        int[] arr = {0,0,0};
        int target = 0;
        System.out.println(threeSumMulti(arr,target));
    }

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int[] count = new int[101];
        //Arrays.fill(count ,1);
        for (int i : arr){
            count[i]++;
        }
        long ans = 0;
        long sum;
        for (int i = 0;i < arr.length - 2; i ++){
            if (arr[i] + arr[arr.length-1] + arr[arr.length - 2] < target){
                continue;
            }
            if (arr[i] > target ){
                break;
            }
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right){

                sum = arr[i] + arr[left] + arr[right];
                if (sum > target){
                    right--;
                } else if(sum < target) {
                    left++;
                } else if (arr[left] == arr[right]){
                    System.out.println(arr[i] + "," + arr[left] + "," + arr[right]);
                    System.out.println("add:"+ count[arr[left]] * (count[arr[left]] - 1) / 2);
                    ans += (long) count[arr[left]] * (count[arr[left]] - 1) / 2;
                    break;
                } else {
                    if(arr[left] == arr[i]){
                        System.out.println(arr[i] + "," + arr[left] + "," + arr[right]);
                        System.out.println("add:"+count[arr[left]] * count[arr[right]]);
                        ans += (long) (count[arr[left]] - 1) * count[arr[right]];
                    } else {
                        System.out.println(arr[i] + "," + arr[left] + "," + arr[right]);
                        System.out.println("add:"+count[arr[left]] * count[arr[right]]);
                        ans += (long) count[arr[left]] * count[arr[right]];
                    }
                    do {
                        left++;
                    }while (left < right && arr[left] == arr[left - 1]);
                    do {
                        right--;
                    } while (right > left && arr[right] == arr[right + 1]);
                }
            }
        }
        return (int)ans % (int)(1e9 + 7);
    }
}
