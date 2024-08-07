package sort;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.removeIf("2"::equals);
        System.out.println(list.get(0));
    }
}
