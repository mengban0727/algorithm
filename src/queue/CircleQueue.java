package queue;

/**
 * 循环队列
 *
 * @author zhangjie
 */
public class CircleQueue {

  private String[] items;
  private int capacity;
  private int head;
  private int tail;

  public CircleQueue(int capacity) {
    this.items = new String[capacity];
    this.capacity = capacity;
    this.head = 0;
    this.tail = 0;
  }

  public boolean enqueue(String val) {
    //队列满了
    if ((tail + 1) % capacity == head) {
      return false;
    }

    items[tail] = val;
    tail = (tail + 1) % capacity;
    return true;
  }

  public String dequeue() {

    //队列为空
    if (head == tail) {
      return null;
    }
    String result = items[head];
    head = (head + 1) % capacity;
    return result;
  }


}
