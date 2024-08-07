package sort;

import org.junit.Test;

public class Sorts2 {
    @Test
    public void sort(){
        int[] num ={2,5,1,6,873,4512,23,41,62};
        quickSort(num, 0, num.length-1);
        for (int i:num
             ) {
            System.out.println(i);
        }
    }
    public void quickSort(int[] num, int start, int end){
        if (start< end){
            int left = start;
            int right = end;
            int stand = num[start];
            while (left < right){
                while (left < right && num[right] >= stand){
                    right --;
                }
                num[left] = num[right];
                while (left < right && num[left] <= stand){
                    left ++;
                }
                num[right] = num[left];
            }
            num[left] = stand;
            quickSort(num, start, left-1);
            quickSort(num, left +1, end);
        }
    }
}
