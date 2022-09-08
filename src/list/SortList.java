package list;

/**
 * @author zhangjie
 */
public class SortList {

  public static class ListNode {

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

  public ListNode sortList(ListNode head) {
    ListNode curr = head;

    int length = 0;
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    ListNode dummyHead = new ListNode(0, head);
    for (int i = 1; i < length; i <<= 1) {
      ListNode preHead = dummyHead;
      curr = dummyHead.next;
      while (curr != null) {
        ListNode head1 = curr;
        for (int j = 1; j < i && curr != null&& curr.next != null; j++) {
          curr = curr.next;
        }

        ListNode head2 = curr.next;
        curr.next = null;
        curr = head2;
        for (int j = 1; j < i && curr != null && curr.next != null; j++) {
          curr = curr.next;
        }
        ListNode next = null;
        if (curr != null) {
          next = curr.next;
          curr.next = null;
        }

        ListNode mergeNode = merge(head1, head2);
        preHead.next = mergeNode;
        while (preHead.next != null) {
          preHead = preHead.next;
        }
        curr = next;
      }


    }
    return dummyHead.next;
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode tmp = new ListNode();
    ListNode node = tmp;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        node.next = l1;
        l1 = l1.next;
        node = node.next;
      } else {
        node.next = l2;
        l2 = l2.next;
        node = node.next;
      }
    }
    if (l1 != null) {
      node.next = l1;
    } else {
      node.next = l2;
    }

    return tmp.next;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(-1,
        new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
    SortList sortList = new SortList();
    sortList.sortList(head);
  }


}
