package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangjie
 */
public class UniquePaths {

  List<List<String>> result;

  public int uniquePaths(int m, int n) {
    result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    return dfs(0, m, 0, n, result, path);
  }

  public int dfs(int left, int right, int top, int bottom, List<List<String>> result,
      List<String> path) {
    if (left == right && top == bottom) {
      result.add(new ArrayList<>(path));
      return 1;
    }
    int res = 0;
    if (left < right) {
      path.add("→");
      res += dfs(left + 1, right, top, bottom, result, path);
      path.remove(path.size() - 1);
    }

    if (top < bottom) {
      path.add("↓");
      res += dfs(left, right, top + 1, bottom, result, path);
      path.remove(path.size() - 1);
    }

    return res;
  }

  public static void main(String[] args) {
    UniquePaths test = new UniquePaths();
    test.uniquePaths(3, 2);
    Set<String> result = new HashSet<>();
    test.result.forEach(l -> {
      StringBuilder sb = new StringBuilder();
      l.forEach(sb::append);
      String s = sb.toString();
      if (result.contains(s)) {
        System.out.println("重复"+s);
      } else {
        result.add(s);
      }
    });
    result.forEach(System.out::println);

  }
}
