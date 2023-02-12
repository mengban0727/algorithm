package tree;


/**
 * 路径总和 https://leetcode.cn/problems/path-sum/description/?orderBy=hot
 *
 * @author zhangjie
 */
public class PathSum {

  /**
   * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false
   */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    int sum = 0;
    return dfs(root, targetSum, sum + root.val);
  }

  public boolean dfs(TreeNode root, int targetSum, int sum) {
    if (root.left == null && root.right == null) {
      return sum == targetSum;
    }
    boolean f1 = false;
    if (root.left != null) {
      f1 = dfs(root.left, targetSum, sum + root.left.val);
    }
    boolean f2 = false;
    if (root.right != null) {
      f2 = dfs(root.right, targetSum, sum + root.right.val);
    }
    return f1 || f2;
  }


  static class TreeNode {

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
