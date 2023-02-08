package list;

/**
 * 排序链表 https://leetcode.cn/problems/sort-list/
 *
 * https://leetcode.cn/problems/sort-list/solutions/437400/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/?orderBy=hot
 *
 * @author zhangjie
 */
public class SortList {

  public static void main(String[] args) {
    ListNode head = new ListNode(-1,
        new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
    SortList sortList = new SortList();
    sortList.sortList(head);
  }

  /**
   * 归并排序--空间复杂度不符合要求
   */
  public ListNode sortList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode tmp = slow.next;
    slow.next = null;

    ListNode left = sortList1(head);
    ListNode right = sortList1(tmp);
    return merge1(left, right);
  }

  public ListNode merge1(ListNode l1, ListNode l2) {
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
        for (int j = 1; j < i && curr != null && curr.next != null; j++) {
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


  /**
   * 迭代
   */
  public ListNode sortList2(ListNode head) {
    int length = getLength(head);
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    for (int step = 1; step < length; step *= 2) { //依次将链表分成1块，2块，4块...
      //每次变换步长，pre指针和cur指针都初始化在链表头
      ListNode pre = dummy;
      ListNode cur = dummy.next;
      while (cur != null) {
        ListNode h1 = cur; //第一部分头 （第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块...）
        ListNode h2 = split(h1, step);  //第二部分头
        cur = split(h2, step); //剩余部分的头
        ListNode temp = merge3(h1, h2); //将一二部分排序合并
        pre.next = temp; //将前面的部分与排序好的部分连接
        while (pre.next != null) {
          pre = pre.next; //把pre指针移动到排序好的部分的末尾
        }
      }
    }
    return dummy.next;
  }

  public int getLength(ListNode head) {
    //获取链表长度
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  public ListNode split(ListNode head, int step) {
    //断链操作 返回第二部分链表头
    if (head == null) {
      return null;
    }
    ListNode cur = head;
    for (int i = 1; i < step && cur.next != null; i++) {
      cur = cur.next;
    }
    ListNode right = cur.next;
    cur.next = null; //切断连接
    return right;
  }

  public ListNode merge3(ListNode h1, ListNode h2) {
    //合并两个有序链表
    ListNode head = new ListNode(-1);
    ListNode p = head;
    while (h1 != null && h2 != null) {
      if (h1.val < h2.val) {
        p.next = h1;
        h1 = h1.next;
      } else {
        p.next = h2;
        h2 = h2.next;
      }
      p = p.next;
    }
    if (h1 != null) {
      p.next = h1;
    }
    if (h2 != null) {
      p.next = h2;
    }

    return head.next;
  }


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
}
