package list;

/**
 * 单链表反转
 *
 * @author zhangjie
 */
public class ReverseList {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * 反转链表
   */
  public ListNode reverseNode(ListNode head) {

    //头节点为空，所以只有一个节点，返回
    if (head == null || head.next == null) {
      return head;
    }

    //花费多一个指针进行存储
    ListNode cur = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = cur;
      cur = head;
      head = next;
    }
    return cur;
  }


}
