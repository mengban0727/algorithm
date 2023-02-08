package list;


/**
 * 链表的中间节点 https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author zhangjie
 */
public class MiddleNode {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * 中间节点 1 2 3 4 5
   */

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
