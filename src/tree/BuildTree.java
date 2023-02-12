package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjie
 */
public class BuildTree {

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

  public static void main(String[] args) {
    Deque<TreeNode> queue = new LinkedList<>();
    int[] values = {1000000000, 1000000000, Integer.MIN_VALUE, 294967296, Integer.MIN_VALUE,
        1000000000, Integer.MIN_VALUE, 1000000000, Integer.MIN_VALUE, 1000000000};
    TreeNode root = new TreeNode(values[0]);
    queue.add(root);

    int index = 1;
    int preCount = 1;
    while (!queue.isEmpty()) {
      int count = 0;
      for (int i = preCount; i > 0; i--) {
        TreeNode node = queue.poll();
        if (index < values.length && values[index] != Integer.MIN_VALUE) {
          TreeNode left = new TreeNode(values[index]);
          node.left = left;
          queue.add(left);
          count++;
        }
        index++;
        if (index < values.length && values[index] != Integer.MIN_VALUE) {
          TreeNode right = new TreeNode(values[index]);
          node.right = right;
          queue.add(right);
          count++;
        }
        index++;
      }
      preCount = count;
    }
  }
}
