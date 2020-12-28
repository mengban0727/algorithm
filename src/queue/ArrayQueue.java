package queue;

/**
 * 数组实现队列
 *
 * @author zhangjie
 */
public class ArrayQueue {

  /**
   * 存储数据
   */
  private String[] items;

  /**
   * 容量
   */
  private int capacity = 0;

  /**
   * 队列头下标
   */
  private int head = 0;


  /**
   * 队列尾下标
   */
  private int tail = 0;


  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    items = new String[capacity];
  }

  /**
   * 入队，如果tail移动到最右边，可能左侧还有空间（出队操作导致数据不连续）
   */
  public boolean enqueue(String item) {
    //队列满
    if (tail == capacity) {
      return false;
    }

    items[tail++] = item;
    return true;
  }

  /**
   * 入队时，判断是否tail是否道道队尾，并且左侧是否还有空间，如果有则进行数据搬移 思考：队列入队复杂度还是o(1)，通过均摊
   */
  public boolean enqueue2(String item) {
    if (tail == capacity) {
      if (head == 0) {
        return false;
      }

      //数据搬移
      for (int i = head; i < tail; i++) {
        items[i - head] = items[i];
      }

      tail -= head;

      head = 0;
    }

    items[tail++] = item;
    return true;

  }


  public String dequeue() {
    //队列为空的判断条件
    if (head == tail) {
      return null;
    }

    String result = items[head++];
    return result;
  }
}
