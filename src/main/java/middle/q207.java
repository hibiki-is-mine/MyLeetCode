package middle;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @author cyj
 * @date 2024/09/30
 */
public class q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> classMap = new HashMap<>(numCourses);
        for (int[] prerequisite : prerequisites){
            classMap.putIfAbsent(prerequisite[0], new HashSet<>());
            classMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> visited = new HashSet<>();
       for (Map.Entry<Integer, Set<Integer>> entry : classMap.entrySet()){
           if (entry.getValue().isEmpty()){
               visited.add(entry.getKey());
               classMap.remove(entry.getKey());
           }
       }
       if (visited.isEmpty()){
           return false;
       }
       for (Integer i : visited) {
          for (Map.Entry<Integer, Set<Integer>> entry : classMap.entrySet()){
              Set<Integer> value = entry.getValue();
              value.remove(i);

              if (value.isEmpty()){
                  visited.add(entry.getKey());
                  classMap.remove(entry.getKey());
              }
          }
       }
       return visited.isEmpty();
    }
}
