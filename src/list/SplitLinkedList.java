package list;


/**
 * 分割链表 https://leetcode.cn/problems/partition-list/
 *
 * @author zhangjie
 */
public class SplitLinkedList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(2);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;

    partition(l1, 3);
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
}
