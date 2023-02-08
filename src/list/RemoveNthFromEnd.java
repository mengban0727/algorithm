package list;


/**
 * 删除链表的倒数第 N 个结点，返回链表的头节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author zhangjie
 */
public class RemoveNthFromEnd {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * 删除倒数第n个节点  1 2 3 4 5 6 7
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    //删除的是头节点
    if (fast == null) {
      return head.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    //删除的slow+1 处的节点
    slow.next = slow.next.next;
    return head;
  }
}
