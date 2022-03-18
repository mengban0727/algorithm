package recursion;

import java.util.ArrayList;
import java.util.List;

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
}