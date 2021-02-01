package hashtable;

/**
 * 散列表实现
 *
 * 1.散列函数（尽可能随机均匀分布） 2.装载因子，扩容 3.解决hash冲突
 *
 * @author zhangjie
 */
public class HashTable<K, V> {

  /**
   * 默认大小
   */
  private static final int DEFAULT_CAPACITY = 16;

  /**
   * 装载因子
   */
  private static final float LOAD_FACTOR = 0.75f;

  /**
   * 散列表数组
   */
  private Entry<K, V>[] tables;

  /**
   * 索引数量
   */
  private int use = 0;

  /**
   * 元素数量
   */
  private int size = 0;


  static class Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value, Entry<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public HashTable() {
    tables = new Entry[DEFAULT_CAPACITY];
  }

  /**
   * 新增元素
   */
  public void put(K key, V value) {
    //1.散列函数求下标
    int index = hash(key);

    //2.判断index位置是否已经使用，若没有创建哨兵节点
    if (tables[index] == null) {
      tables[index] = new Entry<>(null, null, null);
    }

    //拿到哨兵节点
    Entry<K, V> tmp = tables[index];
    //当前下标没有存放元素
    if (tmp.next == null) {
      tmp.next = new Entry<>(key, value, null);
      size++;
      use++;
      //扩容
      if (use >= tables.length * LOAD_FACTOR) {
        resize();
      }
    }
    //散列冲突
    else {
      tmp = tmp.next;
      do {
        if (tmp.key.equals(key)) {
          tmp.value = value;
          return;
        }
      } while (tmp.next != null);

      //没有找到则，头插入链表
      Entry<K, V> head = tables[index].next;
      tables[index].next = new Entry<>(key, value, head);
      size++;
    }
  }

  private void resize() {
    Entry<K, V>[] oldTables = tables;
    tables = new Entry[tables.length * 2];
    use = 0;

    for (int i = 0; i < oldTables.length; i++) {
      if (oldTables[i] == null || oldTables[i].next == null) {
        continue;
      }

      Entry<K, V> entry = oldTables[i];
      while (entry.next != null) {
        entry = entry.next;
        int index = hash(entry.key);
        if (tables[index] == null) {
          use++;
          tables[index] = new Entry<>(null, null, null);
        }
        tables[index].next = new Entry<>(entry.key, entry.value, tables[index].next);
      }
    }
  }


  public void remove(K key) {
    if (key == null) {
      return;
    }

    int index = hash(key);

    Entry<K, V> entry = tables[index];
    if (entry == null || entry.next == null) {
      return;
    }

    Entry<K, V> pre;
    Entry<K, V> head = tables[index];

    do {
      pre = entry;
      entry = entry.next;

      if (key.equals(entry.key)) {
        pre.next = entry.next;
        size--;
        if (head.next == null) {
          use--;
          return;
        }
      }
    } while (entry.next != null);
  }


  public V get(K key) {
    if (key == null) {
      return null;
    }

    int index = hash(key);
    Entry<K, V> entry = tables[index];
    if (entry == null || entry.next == null) {
      return null;
    }

    while (entry.next != null) {
      entry = entry.next;
      if (key.equals(entry.key)) {
        return entry.value;
      }
    }

    return null;
  }


  /**
   * 散列函数
   */
  private int hash(K key) {
    int h;
    return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % tables.length;
  }


  public static void main(String[] args) {
    HashTable<String,Integer> table = new HashTable<>();
    String key = "123";
    table.put(key,1);
    System.out.println(table.get(key));
    table.remove(key);
    System.out.println(table.get(key));
  }

}
