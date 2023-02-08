package list;


/**
 * 合并两个有序链表 https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author zhangjie
 */
public class MergeTwoList {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * 合并两个有序链表
   */
  public ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
    ListNode preNode = new ListNode(-1);
    ListNode pre = preNode;
    while (listNode1 != null && listNode2 != null) {
      if (listNode1.val < listNode2.val) {
        pre.next = listNode1;
        listNode1 = listNode1.next;
      } else {
        pre.next = listNode2;
        listNode2 = listNode2.next;
      }
      pre = pre.next;
    }

    if (listNode1 != null) {
      pre.next = listNode1;
    } else {
      pre.next = listNode2;
    }

    return preNode.next;
  }


}
