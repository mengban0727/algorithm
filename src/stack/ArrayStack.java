package stack;

/**
 * 基于数组实现的顺序栈
 *
 * @author zhangjie
 */
public class ArrayStack {

  private String[] items;
  private int count;
  private int capacity;

  public ArrayStack(int capacity) {
    this.items = new String[capacity];
    this.capacity = capacity;
    this.count = 0;
  }

  /**
   * 入栈
   */
  public boolean push(String item) {
    if (count == capacity) {
      return false;
    }
    items[count++] = item;
    return true;
  }

  /**
   * 出栈
   */
  public String pop() {
    if (count == 0) {
      return null;
    }

    String item = items[count - 1];
    count--;
    return item;
  }


}
