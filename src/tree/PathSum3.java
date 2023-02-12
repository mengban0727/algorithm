package tree;

import java.util.HashMap;
import java.util.Map;


/**
 * 路径总和3 https://leetcode.cn/problems/path-sum-iii/
 *
 * https://leetcode.cn/problems/path-sum-iii/solutions/1021490/gong-shui-san-xie-yi-ti-shuang-jie-dfs-q-usa7/
 *
 * @author zhangjie
 */
public class PathSum3 {


  private int sum = 0;

  /**
   * 解法1 树的遍历 + DFS
   */
  public int pathSum1(TreeNode root, int targetSum) {
    dfs1(root, targetSum);
    return sum;
  }

  public void dfs1(TreeNode root, int targetSum) {
    if (root == null) {
      return;
    }
    dfs2(root, targetSum, 0);
    dfs1(root.left, targetSum);
    dfs1(root.right, targetSum);
  }

  public void dfs2(TreeNode root, int targetSum, int value) {
    if (root == null) {
      return;
    }
    if (root.val + value == targetSum) {
      sum++;
    }

    dfs2(root.left, targetSum, root.val + value);
    dfs2(root.right, targetSum, root.val + value);
  }


  /**
   * 解法2 树的遍历 + 前缀和
   */
  Map<Long, Integer> map = new HashMap<>();
  int ans;
  long t;

  public int pathSum(TreeNode root, long _t) {
    if (root == null) {
      return 0;
    }
    map.put(0L, 1);
    dfs(root, _t, root.val);
    return sum;
  }

  public void dfs(TreeNode root, long target, long curr) {
    if (map.containsKey(curr - target)) {
      sum += map.get(curr - target);
    }
    map.put(curr, map.getOrDefault(curr, 0) + 1);
    if (root.left != null) {
      dfs(root.left, target, curr + root.left.val);
    }
    if (root.right != null) {
      dfs(root.right, target, curr + root.right.val);
    }
    map.put(curr, map.get(curr) - 1);
  }


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
