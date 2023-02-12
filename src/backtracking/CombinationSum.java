package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和 https://leetcode.cn/problems/combination-sum/description/
 */
class CombinationSum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    dfs(candidates, result, curr, target, 0);
    return result;

  }


  public void dfs(int[] candidates, List<List<Integer>> result, List<Integer> curr, int target,
      int begin) {
    if (target == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }
    if (target < 0) {
      return;
    }

    for (int i = begin; i < candidates.length; i++) {
      int tmp = target - candidates[i];
      if (tmp >= 0) {
        curr.add(candidates[i]);
        dfs(candidates, result, curr, tmp, i);
        curr.remove(curr.size() - 1);
      }
    }
  }


  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    int sum = 0;
    dfs1(candidates, target, result, path, 0, sum);
    return result;
  }

  public void dfs1(int[] candidates, int target, List<List<Integer>> result, Deque<Integer> path,
      int index, int sum) {
    if (sum == target) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (sum + candidates[i] <= target) {
        path.push(candidates[i]);
        dfs1(candidates, target, result, path, i, sum + candidates[i]);
        path.pop();
      }

    }
  }
}