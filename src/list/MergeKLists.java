package list;


/**
 * 合并多个有序链表
 *
 * @author zhangjie
 */
public class MergeKLists {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return merge(lists, 0, lists.length - 1);
  }

  private static ListNode merge(ListNode[] lists, int left, int right) {
    //0,1,2,3,4
    if (left == right) {
      return lists[right];
    }
    int mid = left + (right - left) / 2;

    ListNode listNode1 = merge(lists, left, mid);
    ListNode listNode2 = merge(lists, mid + 1, right);

    return mergeTwoList(listNode1, listNode2);

  }

  private static ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
    ListNode listNode = new ListNode(-1);
    ListNode pre = listNode;
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

    if (listNode1 == null) {
      pre.next = listNode2;
    } else {
      pre.next = listNode1;
    }
    return listNode.next;
  }


}
