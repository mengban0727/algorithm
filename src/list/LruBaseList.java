package list;

/**
 * @author zhangjie
 */
public class LruBaseList<T> {

  /**
   * 容量
   */
  private int capacity;

  /**
   * 头节点
   */
  private Node<T> head;

  /**
   * 时间存储长度
   */
  private int length;

  public LruBaseList() {
    capacity = 10;
    length = 0;

    //空节点
    head = new Node<>();
  }

  public void add(T data) {
    //1.遍历head查找是否已经存在
    Node preNode = findPreNode(data);
    //2.如果存在删除，插入到链表头部
    if (preNode != null) {
      //删除元素
      deleteNode(preNode);
      //插入元素到链表头部
      insertNodeAtBegin(data);
    }
    //3.如果不存在，判断容量是否已经满了，如果满了删除尾部节点，插入到链表头部
    else {
      if (length == capacity) {
        deleteTailNode();
      }
      insertNodeAtBegin(data);
    }
  }

  private void deleteTailNode() {
    if (head.next == null) {
      return;
    }

    Node secondTailNode = head;
    while (secondTailNode.next.next != null) {
      secondTailNode = secondTailNode.next;
    }

    secondTailNode.next = null;
    length--;
  }

  private void insertNodeAtBegin(T data) {
    Node node = new Node(data);
    node.next = head.next;
    head.next = node;
    length++;
  }

  /**
   * 删除存在的节点
   */
  private void deleteNode(Node preNode) {
    preNode.next = preNode.next.next;
    length--;
  }

  /**
   * 查找存在元素的前一个节点
   */
  private Node findPreNode(T data) {
    Node node = head;
    while (node.next != null) {
      if (node.next.data.equals(data)) {
        return node;
      }
      node = node.next;
    }
    return null;
  }


  /**
   * 单链表节点
   */
  public class Node<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 后继指针
     */
    private Node next;

    public Node() {
      this.next = null;
    }

    public Node(T data) {
      this.data = data;
    }
  }
}
