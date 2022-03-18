package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

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

  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    if (n == 0) {
      return;
    }
    int i = 0;
    for (; i < m; ) {
      if (nums1[i] <= nums2[0]) {
        i++;
      } else {
        int tmp = nums1[i];
        nums1[i] = nums2[0];

        int k = 1;
        for (; k < n; k++) {
          if (tmp <= nums2[k]) {
            break;
          } else {
            nums2[k - 1] = nums2[k];
          }
        }
        nums2[k - 1] = tmp;


      }
    }
    for (int j = 0; j < n; j++) {
      nums1[i + j] = nums2[j];
    }

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

  public static List<Integer> getRow(int rowIndex) {
    int[] result = new int[rowIndex + 1];

    for (int i = 0; i < rowIndex + 1; i++) {
      result[i] = 1;
      for (int j = i - 1; j >= 1; j--) {
        result[j] = result[j] + result[j - 1];
      }
    }
    return Arrays.stream(result).boxed().collect(Collectors.toList());
  }

  public static ListNode partition(ListNode head, int x) {
    if (head == null) {
      return head;
    }

    ListNode largeNode = new ListNode();
    ListNode smallNode = new ListNode();

    ListNode large = largeNode;
    ListNode small = smallNode;

    ListNode p = head;
    while (p != null) {
      if (p.val < x) {
        small.next = p;
        small = small.next;
      } else {
        large.next = p;
        large = large.next;
      }
      p = p.next;
    }

    small.next = largeNode.next;
    return smallNode.next;
  }


  public static void main(String[] args) {
    //merge(new int[]{2, 0}, 1, new int[]{1}, 1);

    //getRow(3);

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(2);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(2);
    l1.next = l2;
    l2.next=l3;
    l3.next=l4;
    l4.next=l5;
    l5.next=l6;

    partition(l1,3);

  }

  static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}