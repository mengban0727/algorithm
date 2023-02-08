package list;


/**
 * 环形链表 https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author zhangjie
 */
public class CycleList {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * 检测环形链表
   */
  public boolean hasCycle(ListNode head) {
    //只有一个节点
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return true;


  }


}
