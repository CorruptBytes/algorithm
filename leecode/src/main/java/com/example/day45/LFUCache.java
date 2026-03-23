package com.example.day45;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    private final int capacity;
    private int minFreq = 0;

    private final Map<Integer, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, Map<Integer, Integer>> freqToMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToFreq.containsKey(key)) {
            return -1;
        }
        return increaseFreq(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToFreq.containsKey(key)) {
            updateValueAndFreq(key, value);
            return;
        }

        if (keyToFreq.size() == capacity) {
            evictLFU();
        }

        insertNewKey(key, value);
    }
    private int increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        Map<Integer, Integer> map = freqToMap.get(freq);

        int value = map.remove(key);

        if (map.isEmpty()) {
            freqToMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        keyToFreq.put(key, freq + 1);
        freqToMap
                .computeIfAbsent(freq + 1, k -> new LinkedHashMap<>())
                .put(key, value);

        return value;
    }
    private void updateValueAndFreq(int key, int newValue) {
        int freq = keyToFreq.get(key);
        Map<Integer, Integer> map = freqToMap.get(freq);

        map.remove(key);

        if (map.isEmpty()) {
            freqToMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        keyToFreq.put(key, freq + 1);
        freqToMap
                .computeIfAbsent(freq + 1, k -> new LinkedHashMap<>())
                .put(key, newValue);
    }
    private void evictLFU() {
        Map<Integer, Integer> map = freqToMap.get(minFreq);

        Integer oldestKey = map.keySet().iterator().next();
        map.remove(oldestKey);
        keyToFreq.remove(oldestKey);

        if (map.isEmpty()) {
            freqToMap.remove(minFreq);
        }
    }
    private void insertNewKey(int key, int value) {
        keyToFreq.put(key, 1);
        freqToMap
                .computeIfAbsent(1, k -> new LinkedHashMap<>())
                .put(key, value);
        minFreq = 1;
    }
}
class LFUCacheV2 {
    private final int capacity;
    private final Map<Integer, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, Map<Integer, Integer>> freqToMap = new HashMap<>();
    private int minFreq;

    public LFUCacheV2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return move(key, null);
    }

    public void put(int key, int value) {
        if (move(key, value) != -1) { // 有这本书
            return;
        }
        if (keyToFreq.size() == capacity) { // 书太多了
            Map<Integer, Integer> map = freqToMap.get(minFreq); // 最左边那摞书
            Integer oldestKey = map.keySet().iterator().next(); // 这摞书最下面的书
            map.remove(oldestKey); // 移除
            keyToFreq.remove(oldestKey);
        }
        // 新书，放在「看过 1 次」的最上面
        keyToFreq.put(key, 1);
        freqToMap.computeIfAbsent(1, k -> new LinkedHashMap<>()).put(key, value);
        minFreq = 1;
    }

    // 把 key 从第 freq 摞书中抽出来，放到第 freq+1 摞书的最上面
    // 返回 key 对应的 value
    private int move(Integer key, Integer value) {
        Integer freq = keyToFreq.getOrDefault(key, null);
        if (freq == null) { // 没有这本书
            return -1;
        }
        Map<Integer, Integer> map = freqToMap.get(freq);
        Integer v = map.remove(key); // 从第 freq 摞书中抽出来
        if (value == null) {
            value = v;
        }
        // 抽出来后，这摞书是空的，且这摞书是最左边的
        if (map.size() == 0 && minFreq == freq) {
            minFreq++;
        }
        // 看书次数 +1
        keyToFreq.merge(key, 1, Integer::sum);
        // 放在右边这摞书的最上面
        freqToMap.computeIfAbsent(freq + 1, k -> new LinkedHashMap<>()).put(key, value);
        return value;
    }
}

class LFUCache1 {

    Map<Integer, Node> cache;  // 存储缓存的内容，Node中除了value值外，还有key、freq、所在doublyLinkedList、所在doublyLinkedList中的postNode、所在doublyLinkedList中的preNode，具体定义在下方。

    DoublyLinkedList firstLinkedList; // firstLinkedList.post 是频次最大的双向链表

    DoublyLinkedList lastLinkedList;  // lastLinkedList.pre 是频次最小的双向链表，满了之后删除 lastLinkedList.pre.tail.pre 这个Node即为频次最小且访问最早的Node

    int size;

    int capacity;



    public LFUCache1(int capacity) {
        cache = new HashMap<> (capacity);
        firstLinkedList = new DoublyLinkedList();
        lastLinkedList = new DoublyLinkedList();
        firstLinkedList.post = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
        this.capacity = capacity;

    }



    public int get(int key) {

        Node node = cache.get(key);
        if (node == null) {
          return -1;
        }
        // 该key访问频次+1
        freqInc(node);
        return node.value;

    }



    public void put(int key, int value) {

    if (capacity == 0) {
      return;
    }
    Node node = cache.get(key);
    // 若key存在，则更新value，访问频次+1
    if (node != null) {
      node.value = value;
      freqInc(node);
    } else {
        // 若key不存在
      if (size == capacity) {
        // 如果缓存满了，删除lastLinkedList.pre这个链表（即表示最小频次的链表）中的tail.pre这个Node（即最小频次链表中最先访问的Node），如果该链表中的元素删空了，则删掉该链表。
        cache.remove(lastLinkedList.pre.tail.pre.key);
        lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
        size--;
        if (lastLinkedList.pre.head.post == lastLinkedList.pre.tail) {
          removeDoublyLinkedList(lastLinkedList.pre);
        }
      }
      // cache中put新Key-Node对儿，并将新node加入表示freq为1的DoublyLinkedList中，若不存在freq为1的DoublyLinkedList则新建。
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      if (lastLinkedList.pre.freq != 1) {
        DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(1);
        addDoublyLinkedList(newDoublyLinedList, lastLinkedList.pre);
        newDoublyLinedList.addNode(newNode);
      } else {
        lastLinkedList.pre.addNode(newNode);
      }
      size++;
    }

    }


    /**
     * node的访问频次 + 1
     */
    void freqInc(Node node) {
        // 将node从原freq对应的双向链表里移除, 如果链表空了则删除链表。
        DoublyLinkedList linkedList = node.doublyLinkedList;
        DoublyLinkedList preLinkedList = linkedList.pre;
        linkedList.removeNode(node);
        if (linkedList.head.post == linkedList.tail) {
            removeDoublyLinkedList(linkedList);
        }

        // 将node加入新freq对应的双向链表，若该链表不存在，则先创建该链表。
        node.freq++;
        if (preLinkedList.freq != node.freq) {
            DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(node.freq);
            addDoublyLinkedList(newDoublyLinedList, preLinkedList);
            newDoublyLinedList.addNode(node);
        } else {
            preLinkedList.addNode(node);
        }

    }


    /**
     * 增加代表某1频次的双向链表
     */
    void addDoublyLinkedList(DoublyLinkedList newDoublyLinedList, DoublyLinkedList preLinkedList) {
        newDoublyLinedList.post = preLinkedList.post;
        newDoublyLinedList.post.pre = newDoublyLinedList;
        newDoublyLinedList.pre = preLinkedList;
        preLinkedList.post = newDoublyLinedList;
    }


    /**
     * 删除代表某1频次的双向链表
     */
    void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        doublyLinkedList.pre.post = doublyLinkedList.post;
        doublyLinkedList.post.pre = doublyLinkedList.pre;

    }

}



class Node {

    int key;

    int value;

    int freq = 1;

    Node pre; // Node所在频次的双向链表的前继Node

    Node post; // Node所在频次的双向链表的后继Node

    DoublyLinkedList doublyLinkedList;  // Node所在频次的双向链表



    public Node() {}



    public Node(int key, int value) {
        this.key = key;
        this.value = value;

    }

}



class DoublyLinkedList {

    int freq; // 该双向链表表示的频次

    DoublyLinkedList pre;  // 该双向链表的前继链表（pre.freq < this.freq）

    DoublyLinkedList post; // 该双向链表的后继链表 (post.freq > this.freq)

    Node head; // 该双向链表的头节点，新节点从头部加入，表示最近访问

    Node tail; // 该双向链表的尾节点，删除节点从尾部删除，表示最久访问


    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }


    public DoublyLinkedList(int freq) {
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
        this.freq = freq;

    }


    void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;

    }


    void addNode(Node node) {

        node.post = head.post;

        head.post.pre = node;

        head.post = node;

        node.pre = head;

        node.doublyLinkedList = this;

    }
}




