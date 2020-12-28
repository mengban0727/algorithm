package queue;

/**
 * 链表实现队列
 *
 * @author zhangjie
 */
public class LinkedListQueue<T> {

  private ListNode head;

  private ListNode tail;

  public void enqueue(T val) {
    ListNode node = new ListNode(val);

    if (tail == null) {
      tail = node;
      head = node;
    } else {
      tail.next = node;
      tail = tail.next;
    }
  }

  public Object dequeue() {
    if (head == null) {
      return null;
    }

    Object data = head.val;
    head = head.next;

    if (head == null) {
      tail = null;
    }
    return data;
  }


  class ListNode<T> {

    T val;
    ListNode next;

    ListNode(T x) {
      val = x;
    }
  }
}
