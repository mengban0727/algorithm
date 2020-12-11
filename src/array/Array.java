package array;

/**
 * 数组基本功能 1.插入 2.删除 3.查找 4.更新 5.扩容
 *
 * @author zhangjie
 */
public class Array<T> {

  private T[] data;

  /**
   * 当前存储的数量
   */
  private int size;

  public Array() {
    this(10);
  }

  public Array(int capacity) {
    data = (T[]) new Object[capacity];
    size = 0;
  }

  /**
   * 头部插入元素
   */
  public void addFirst(T e) {
    add(0, e);
  }

  /**
   * 尾部插入元素
   */
  public void addLast(T e) {
    add(size, e);
  }

  /**
   * 在index位置插入元素e
   *
   * @param index 下标
   * @param e 元素
   */
  public void add(int index, T e) {
    //检查下标是否越界
    checkIndexForAdd(index);
    //判断是否需要扩容
    if (data.length == size) {
      resize(2 * size);
    }
    //将要插入的位置的数据进行后移,从后往前
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;

    size++;
  }

  /**
   * 移除某个元素e
   */
  public void remove(T e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }

  /**
   * 移除某个下标的元素,并返回
   */
  public T remove(int index) {
    checkIndex(index);

    T element = data[index];

    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    size--;
    data[size - 1] = null;

    //判断是否要缩容
    if (size == data.length / 4 && data.length / 2 != 0) {
      resize(data.length / 2);
    }

    return element;

  }

  /**
   * 查找某个元素的下标
   */
  public int find(T e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 更新index位置的元素为e
   *
   * @param index 下标
   * @param e 更新的值
   */
  public void set(int index, T e) {
    checkIndex(index);
    data[index] = e;
  }

  /**
   * 获取index位置的元素
   */
  public T get(int index) {
    checkIndex(index);
    return data[index];
  }


  /**
   * 扩容
   */
  private void resize(int capacity) {
    T[] newData = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  /**
   * 插入时检查下标
   */
  private void checkIndexForAdd(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("下标错误");
    }
  }

  /**
   * 校验下标
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("下标错误");
    }
  }

  public static void main(String[] args) {

  }
}
