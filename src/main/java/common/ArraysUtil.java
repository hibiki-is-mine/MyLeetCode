package common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cyj
 * @date 2024/09/30
 */
public class ArraysUtil {

    public static int[][] formatArray(String str){
        Gson gson = new Gson();
        List<List<Integer>> list = gson.fromJson(str, new TypeToken<List<List<Integer>>>(){}.getType());

        int[][] array = new int[list.size()][];
        int index = 0;
        for (List<Integer> sublist : list) {
            array[index++] = sublist.stream().mapToInt(i -> i).toArray();
        }
        return array;

    }
}
