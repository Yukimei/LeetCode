package Google;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node sentinel;
    Map<Integer, Node> map;
    int size;
    int capacity;
    public LRUCache(int capacity) {
        sentinel = new Node(-1, -1, null, null);
        sentinel.left = sentinel;
        sentinel.right = sentinel;
        
        map = new HashMap<Integer, Node>();
        size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            moveToHead(node);
            return node.val;
        } 
        return -1;
    }
    
    public void set(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        } else if (size == capacity) {
            deleteEnd();
            size--;
        } 
        node = new Node(key, value, sentinel, sentinel.right);
        sentinel.right.left = node;
        sentinel.right = node;
        size++;
        map.put(key, node);
    }
    
    private void moveToHead(Node node) {
        Node left = node.left;
        Node right = node.right;
        
        left.right = right;
        right.left = left;
        
        node.left = sentinel;
        node.right = sentinel.right;
        
        sentinel.right.left = node;
        sentinel.right = node;
    }
    
    private void deleteEnd() {
        int removeKey = sentinel.left.key;
        sentinel.left = sentinel.left.left;
        sentinel.left.right = sentinel;
        map.remove(removeKey);
    }
    class Node {
        int key;
        int val;
        Node left;
        Node right;
        Node(int key, int val, Node left, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
    	LRUCache l = new LRUCache(1);
    	l.set(2, 1);
    	l.get(2);
    	l.set(3, 2);
    	System.out.println(l.get(2));
    }
    
}