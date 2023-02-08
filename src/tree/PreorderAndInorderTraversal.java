package tree;

/**
 * 从前序与中序遍历序列构造二叉树 https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class PreorderAndInorderTraversal {
  public static void main(String[] args) {

  }
  public TreeNode buildTree(int[] preorder, int[] inorder) {

    return bulidTreeDfs(preorder, 0, preorder.length, inorder, 0, inorder.length);
  }

  private TreeNode bulidTreeDfs(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart,
      int iEnd) {

    if (pStart == pEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[pStart]);

    int i = iStart;
    for (; i < iEnd; i++) {
      if (preorder[pStart] == inorder[i]) {
        break;
      }
    }

    //3,9,20,15,7
    //9,3,15,20,7

    int leftNum = i - iStart;

    root.left = bulidTreeDfs(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, i);
    root.right = bulidTreeDfs(preorder, pStart + leftNum + 1, pEnd, inorder, i + 1, iEnd);
    return root;

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