package heap;

/**
 * @author zhangjie
 */
public class Heap {

  /**
   * 从下标1开始存储
   */
  private int[] array;

  /**
   * 堆存储的最大数据个数
   */
  private int capacity;

  /**
   * 堆中已经存储的个数
   */
  private int count;

  public Heap(int capacity) {
    this.array = new int[capacity + 1];
    this.capacity = capacity;
    this.count = 0;
  }

  /**
   * 堆插入---从下往上堆话
   */
  public void insert(int data) {
    if (count >= capacity) {
      return;
    }

    count++;
    array[count] = data;
    int i = count;

    while (i / 2 > 0 && array[i] > array[i / 2]) {
      swap(array, array[i], array[i / 2]);
      i = i / 2;
    }
  }

  public void swap(int[] array, int child, int parent) {
    int tmp = array[parent];
    array[parent] = array[child];
    array[child] = tmp;
  }

  public int removeMax() {
    if (count == 0) {
      return -1;
    }

    int result = array[1];
    array[1] = array[count];
    --count;

    heapify(array, count, 1);
    return result;
  }

  /**
   * 从上到下堆化
   */
  private void heapify(int[] array, int count, int i) {
    while (true) {
      int maxPos = i;

      if (i * 2 <= count && array[i] < array[i * 2]) {
        maxPos = i * 2;
      }

      if (i * 2 + 1 <= count && array[maxPos] < array[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }

      if (maxPos == i) {
        break;
      }
      swap(array, i, maxPos);
      i = maxPos;
    }

  }

  /**
   * 建堆-从上往下堆化
   */
  public void buildHeap(int[] array, int count) {
    for (int i = count / 2; i >= 1; i--) {
      heapify(array, count, i);
    }
  }

  /**
   * 排序
   */
  public void sort(int[] array, int count) {
    buildHeap(array, count);
    int k = count;
    while (k > 1) {
      swap(array, k, 1);
      k--;
      heapify(array, k, 1);
    }
  }


}
