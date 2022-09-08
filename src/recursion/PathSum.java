package recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjie
 */
public class PathSum {

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

  private int sum = 0;

  public int pathSum(TreeNode root, int targetSum) {
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

  public static void main(String[] args) {
    Deque<TreeNode> queue = new LinkedList<>();
    int[] values = {1000000000, 1000000000, Integer.MIN_VALUE, 294967296, Integer.MIN_VALUE,
        1000000000, Integer.MIN_VALUE, 1000000000, Integer.MIN_VALUE, 1000000000};
    TreeNode root = new TreeNode(values[0]);
    queue.add(root);

    int index = 1;
    int preCount = 1;
    while(!queue.isEmpty()){
      int count = 0;
      for(int i = preCount; i>0; i--){
        TreeNode node = queue.poll();
        if(index<values.length&&values[index]!=Integer.MIN_VALUE){
          TreeNode left = new TreeNode(values[index]);
          node.left = left;
          queue.add(left);
          count++;
        }
        index++;
        if(index<values.length&&values[index]!=Integer.MIN_VALUE){
          TreeNode right = new TreeNode(values[index]);
          node.right = right;
          queue.add(right);
          count++;
        }
        index++;
      }
      preCount = count;
    }

    PathSum pathSum = new PathSum();
    pathSum.pathSum(root,0);
    System.out.println(pathSum.sum);

  }
}
