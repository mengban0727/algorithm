package stack;


/**
 * 基于链表实现的栈
 *
 * @author zhangjie
 */
public class LinkedListStack<T> {

  /**
   * 栈顶元素
   */
  private ListNode top = null;

  protected int size = 0;

  public void push(T val) {
    ListNode node = new ListNode(val);
    if (top == null) {
      top = node;
    } else {
      node.next = top;
      top = node;
    }

    size++;
  }

  public T pop() {
    if (top == null) {
      return null;
    }
    T val = (T) top.val;

    top = top.next;

    size--;
    return val;
  }

  public void clear() {
    this.top = null;
    size = 0;
  }


  class ListNode<T> {

    T val;
    ListNode next;

    ListNode(T x) {
      val = x;
    }
  }
}
