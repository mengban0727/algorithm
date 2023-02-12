package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 不同路径 https://leetcode.cn/problems/unique-paths/description/
 *
 * @author zhangjie
 */
public class UniquePaths {

  /**
   * dp方式实现
   */
  public int uniquePathsDp(int m, int n) {
    //dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
    //只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }


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


  /**
   * 回溯剪枝
   */
  int[][] dp;

  public int dfs2(int bottom, int maxBottom, int right, int maxRight) {
    if (bottom == maxBottom && right == maxRight) {
      return 1;
    }
    if (bottom > maxBottom || right > maxRight) {
      return 0;
    }
    if (dp[bottom][right] != 0) {
      return dp[bottom][right];
    }

    int v1 = dfs2(bottom + 1, maxBottom, right, maxRight);
    int v2 = dfs2(bottom, maxBottom, right + 1, maxRight);
    dp[bottom][right] = v1 + v2;
    return v1 + v2;
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
        System.out.println("重复" + s);
      } else {
        result.add(s);
      }
    });
    result.forEach(System.out::println);

  }
}
