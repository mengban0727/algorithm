package hashtable;

import java.util.HashMap;

/**
 * @author zhangjie
 */
public class LruBaseHashTable<K, V> {

  private LNode<K, V> head;

  private LNode<K, V> tail;

  private Integer length;

  private Integer capacity;

  private HashMap<K, LNode<K, V>> table;

  static class LNode<K, V> {

    private K key;
    private V value;
    private LNode<K, V> pre;
    private LNode<K, V> next;

    LNode() {
    }

    LNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public LruBaseHashTable(int capacity) {
    this.length = 0;
    this.capacity = capacity;
    head = new LNode<>();
    tail = new LNode<>();
    head.next = tail;
    tail.pre = head;
    table = new HashMap<>();
  }

  public void add(K key, V value) {
    LNode<K, V> node = table.get(key);
    if (node == null) {
      LNode<K, V> newNode = new LNode<>(key, value);
      table.put(key, newNode);
      addNode(newNode);

      //链表满了
      if (++length > capacity) {
        LNode<K, V> tail = popTail();
        table.remove(tail.key);
        length--;
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }


  public V get(K key) {
    LNode<K, V> node = table.get(key);
    if (node == null) {
      return null;
    }
    moveToHead(node);
    return node.value;
  }


  public void remove(K key){
    LNode<K,V> node = table.get(key);
    if(node==null){
      return;
    }

    removeNode(node);
    length--;
    table.remove(node.key);
  }


  private void moveToHead(LNode<K, V> node) {
    removeNode(node);
    addNode(node);
  }

  private LNode<K, V> popTail() {
    LNode<K, V> node = tail.pre;
    removeNode(node);
    return node;
  }

  private void removeNode(LNode<K, V> node) {
    node.next.pre = node.pre;
    node.pre.next = node.next;
  }

  private void addNode(LNode<K, V> newNode) {
    newNode.next = head.next;
    newNode.pre = head;
    head.next.pre = newNode;
    head.next = newNode;
  }

}
