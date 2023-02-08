package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 https://leetcode.cn/problems/subsets/
 *
 * @author zhangjie
 */
public class Subsets {

  public static void main(String[] args) {
    List<List<Integer>> result = new Subsets().subsetsWithDup(new int[]{1, 2, 3});
    System.out.println(result);

    List<List<Integer>> result1 = new Subsets().subsets(new int[]{1, 2, 3});
    System.out.println(result1);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Arrays.sort(nums);
    dfs(result, path, nums, 0);
    return result;
  }


  private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int level) {
    result.add(new ArrayList<>(path));

    for (int i = level; i < nums.length; i++) {
      if (i > level && nums[i] == nums[i - 1]) {
        continue;
      }

      path.add(nums[i]);
      dfs(result, path, nums, i + 1);
      path.remove(path.size() - 1);

    }
  }


  public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(nums, result, path, 0);
    return result;
  }

  public void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int level) {
    result.add(new ArrayList<>(path));

    for (int i = level; i < nums.length; i++) {
      path.add(nums[i]);
      dfs(nums, result, path, i + 1);
      path.remove(path.size() - 1);
    }
  }

}
