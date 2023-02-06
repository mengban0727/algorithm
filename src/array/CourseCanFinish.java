package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 课程表 https://leetcode.cn/problems/course-schedule/
 *
 * @author zhangjie
 */
public class CourseCanFinish {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, List<Integer>> map2 = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      map1.put(i, 0);
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
      if (nextList == null) {
        continue;
      }
      for (Integer course : nextList) {
        map1.put(course, map1.get(course) - 1);
        if (map1.get(course) == 0) {
          queue.offer(course);
        }
      }


    }
    return count == numCourses;
  }

  public static void main(String[] args) {
    //canFinish(2, new int[][]{{1, 0}});
    System.out.println(canFinish2(2, new int[][]{{1, 0}}));
  }

  public static boolean canFinish2(int numCourses, int[][] prerequisites) {
    //入读
    int[] course1 = new int[numCourses];
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    for (int i = 0; i < prerequisites.length; i++) {
      int[] tmp = prerequisites[i];
      int curr = tmp[0];
      int next = tmp[1];
      course1[next]++;
      if (!adjMap.containsKey(curr)) {
        adjMap.put(curr, new ArrayList<>());
      }
      adjMap.get(curr).add(next);
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < course1.length; i++) {
      if (course1[i] == 0) {
        queue.add(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      Integer course = queue.poll();
      count++;
      List<Integer> adj = adjMap.get(course);
      if(adj==null){
        continue;
      }
      for (int i = 0; i < adj.size(); i++) {
        course1[adj.get(i)]--;
        if (course1[adj.get(i)] == 0) {
          queue.add(adj.get(i));
        }
      }
    }

    return count == numCourses;

  }
}
