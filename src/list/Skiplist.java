package list;

import java.util.Random;

class Skiplist {
  /**
   * 跳表最大层数
   */
  private static final int MAX_LEVEL =16;

  /**
   * 当前跳表层数
   */
  private int levelCount = 1;

  /**
   * 头节点
   */
  private Node head = new Node(MAX_LEVEL);

  /**
   * 新增结点时，随机到哪一层
   */
  private Random random = new Random();

  /**
   * 插入节点
   */
  public void add(int value) {
    //当前节点到哪一层的索引
    int level = head.nextNodes[0] == null ? 1 : randomLevel();

    //每次最多增加一层的索引
    if (level > levelCount) {
      level = ++levelCount;
    }

    Node newNode = new Node(level);
    newNode.data = value;

    /**
     * 遍历层级索引指针
     null:15-------
     null:14-------
     null:13-------
     null:12-------
     null:11-------
     null:10-------
     null:9-------
     null:8-------
     null:7-------
     null:6-------
     null:5-------
     (4:4)-------
     (4:3)-------8:3-------
     (4:2)-------5:2-------6:2-------7:2-------8:2-------
     2:1-------3:1-------(4:1)-------5:1-------6:1-------7:1-------8:1-------
     1:0-------2:0-------3:0-------(4:0)-------5:0-------6:0-------7:0-------8:0-------
     */
    Node preNode = head;
    //从最大层开始遍历
    for (int i = levelCount - 1; i >= 0; i--) {
      //找到当前层级索引最后一个小于value的节点，也就是node插入时的前一节点
      while (preNode.nextNodes[i] != null && preNode.nextNodes[i].data < value) {
        preNode = preNode.nextNodes[i];
      }

      //从最上层开始找到符合的层级，如果比这个节点的最大层级索引大，则不建立层级索引
      if (i > level - 1) {
        continue;
      }

      //第i层建立索引
      if (preNode.nextNodes[i] == null) {
        preNode.nextNodes[i] = newNode;
      } else {
        Node nextNode = preNode.nextNodes[i];
        preNode.nextNodes[i] = newNode;
        newNode.nextNodes[i] = nextNode;
      }
    }
  }

  public boolean erase(int target) {
    boolean eraseFlag = false;

    //找到节点每一层索引之前的节点
    Node[] preNodes = new Node[levelCount];
    Node preNode = head;

    for (int i = levelCount - 1; i >= 0; i--) {
      while (preNode.nextNodes[i] != null && preNode.nextNodes[i].data < target) {
        preNode = preNode.nextNodes[i];
      }
      preNodes[i] = preNode;
    }

    //判断是否找到
    if (preNode.nextNodes[0] != null && preNode.nextNodes[0].data == target) {

      //删除找到节点在每一层的索引
      for (int i = levelCount - 1; i >= 0; i--) {
        if (preNodes[i].nextNodes[i] != null && preNodes[i].nextNodes[i].data == target) {
          preNodes[i].nextNodes[i] = preNodes[i].nextNodes[i].nextNodes[i];
          eraseFlag = true;
        }
      }
    }
    System.out.println("erase:"+target+"-"+eraseFlag);
    return eraseFlag;
  }

  public boolean search(int target) {
    boolean searchFlag;
    Node preNode = head;

    for (int i = levelCount - 1; i >= 0; i--) {
      while (preNode.nextNodes[i] != null && preNode.nextNodes[i].data < target) {
        preNode = preNode.nextNodes[i];
      }

    }

    if (preNode.nextNodes[0] != null && preNode.nextNodes[0].data == target) {
      searchFlag = true;
    } else {
      searchFlag =false;
    }

    System.out.println("search:"+target+"-"+searchFlag);
    return searchFlag;
  }


  /**
   * 节点构建level层高度的索引
   */
  private int randomLevel() {
    int level = 1;

    for (int i = 1; i < MAX_LEVEL; i++) {
      if (random.nextInt() % 2 == 1) {
        level++;
      }
    }
    return level;
  }


  /**
   * 打印所有数据
   */
  public void printAll() {
    Node pre = head;
    //所有层的第一个节点
    Node[] c = pre.nextNodes;
    Node[] d = c;
    int maxLevel = c.length;
    for (int i = maxLevel - 1; i >= 0; i--) {
      do {
        System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
      } while (d[i] != null && (d = d[i].nextNodes)[i] != null);
      System.out.println();
      d = c;
    }
  }

  /**
   * 跳表节点，记录当前节点数据和 当前所在的层以及下面所有层的下一节点数据
   */
  public class Node {

    /**
     * 节点数据
     */
    private int data = -1;

    /**
     * 前所在的层以及下面所有层的下一节点数据
     */
    private Node[] nextNodes;

    public Node(int level) {
      nextNodes = new Node[level];
    }
  }


  public static void main(String[] args) {

    Skiplist skiplist = new Skiplist();
    skiplist.add(9);
    skiplist.add(4);
    skiplist.add(5);
    skiplist.add(6);
    skiplist.add(9);
    skiplist.erase(2);
    skiplist.erase(1);
    skiplist.add(2);
    skiplist.search(7);
    skiplist.search(4);
    skiplist.add(5);
    skiplist.erase(6);
    skiplist.search(5);
    skiplist.add(6);
    skiplist.add(7);
    skiplist.add(4);
    skiplist.erase(3);
    skiplist.search(6);
    skiplist.erase(3);
    skiplist.search(4);
    skiplist.search(3);
    skiplist.search(8);
    skiplist.erase(7);
    skiplist.erase(6);
    skiplist.search(7);
    skiplist.erase(4);
    skiplist.add(1);
    skiplist.add(6);
    skiplist.erase(3);
    skiplist.add(4);
    skiplist.search(7);
    skiplist.search(6);
    skiplist.search(1);
    skiplist.search(0);
    skiplist.search(3);
  }











}