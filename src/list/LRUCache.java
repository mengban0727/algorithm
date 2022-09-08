package list;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private int count;
    private ListNode head;
    private ListNode tail;
    private Map<Integer,ListNode> map;
    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.count=0;
      map = new HashMap<>(capacity<<1);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        if(node==head){
            return node.value;
        }

        ListNode preNode = node.pre;
        preNode.next = node.next;
        if(node.next==null){
            tail = preNode;
        }else{
            node.next.pre = preNode;
        }

        node.pre = null;
        node.next= head;
        head.pre = node;
        head = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode newNode = new ListNode(key,value);
        if(head==null){
            head = newNode;
            tail = newNode;
            map.put(key,newNode);
            count++;
        }else if(map.containsKey(key)){
                newNode =  map.get(key);
                newNode.value = value;
                if(newNode==head){
                  return;
                }

                ListNode preNode = newNode.pre;
                preNode.next = newNode.next;

                if(newNode!=tail){
                  newNode.next.pre = preNode;
                }else{
                  tail = preNode;
                }
                head.pre = newNode;
                newNode.next = head;
                newNode.pre = null;
                head = newNode;
        }else{
            head.pre = newNode;
            newNode.next = head;
            head = newNode;
            map.put(key,newNode);
            if(count==capacity){
              map.remove(tail.key);
              ListNode preTail = tail.pre;
              preTail.next = null;
              tail.pre = null;
              tail = preTail;
            }else {
              count++;
            }
        }
    
    }
    class ListNode{
        int value;
        int key;
        ListNode next;
        ListNode pre;
        ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(2,1);
    lruCache.put(1,1);
    lruCache.put(2,3);
    lruCache.put(4,1);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(2));
  }
}