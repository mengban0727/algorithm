package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author zhangjie
 */
public class CourseCanFinish {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, List<Integer>> map2 = new HashMap<>();
    for(int i = 0; i < numCourses; i++){
      map1.put(i,0);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int[] course = prerequisites[i];
      int next = course[1];
      int curr = course[0];
      map1.put(curr, map1.getOrDefault(curr, 0) + 1);

      if (!map2.containsKey(next)) {
        map2.put(next, new ArrayList<>());
      }
      map2.get(next).add(curr);
    }
    Queue<Integer> queue = new LinkedList<>();

    for (Integer key : map1.keySet()) {
      if (map1.get(key) == 0) {
        queue.offer(key);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      Integer zeroCourse = queue.poll();
      count++;

      List<Integer> nextList = map2.get(zeroCourse);
      if(nextList==null){
        continue;
      }
      for (Integer course : nextList) {
        map1.put(course, map1.get(course) - 1);
        if(map1.get(course)==0){
          queue.offer(course);
        }
      }


    }
    return count == numCourses;
  }

  public static void main(String[] args) {
    canFinish(2, new int[][]{{1, 0}});
  }
}
