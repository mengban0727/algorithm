package array;

import java.util.HashMap;
import java.util.Map;
import org.omg.CORBA.Object;

/**
 * 基于数组实现LRU缓存
 *
 * @author zhangjie
 */
public class LruBaseArray<T> {

  /**
   * 容量
   */
  private int capacity;

  /**
   * 现在已使用的空间
   */
  private int count;

  /**
   * 存储
   */
  private T[] values;

  /**
   * 存储数据在T中的下标，为了更快的找到，充当索引的作用
   */
  private Map<T, Integer> holder;

  public LruBaseArray(int capacity) {
    this.capacity = capacity;
    count = 0;
    values = (T[]) new Object[capacity];
    holder = new HashMap<>(capacity);
  }


  /**
   * 访问某个值
   */
  public void offer(T object) {

    //1.从holder中获取下标判断是否存在，如果不用map存储，需要遍历整个values
    //2.如果不存在，判断values是否满了，如果满了，需要将最后一位移除，并将object插入到头部,如果没满，存储到头部
    //3.如果存在，将object移动到头部，其他数据右移

    if (object == null) {
      throw new IllegalArgumentException("参数错误");
    }

    Integer index = holder.get(object);
    if (index == null) {
      if (count == capacity) {
        removeAndCache(object);
      } else {
        cache(object);
      }
    } else {
      update(index);
    }
  }

  private void update(Integer index) {
    T target = values[index];
    rightShift(index);
    values[0] = target;
    holder.put(target, 0);
  }

  private void cache(T object) {
    //向右移动
    rightShift(count);

    //缓存在头部
    values[0] = object;
    holder.put(object, 0);
    count++;
  }

  private void removeAndCache(T object) {
    //从缓存中移除
    T key = values[count--];
    holder.remove(key);

    //缓存
    cache(object);
  }

  /**
   * 向右移动
   */
  private void rightShift(int end) {
    for (int i = end - 1; i >= 0; i--) {
      values[i + 1] = values[i];
      holder.put(values[i + 1], i + 1);
    }
  }


}
