import java.util.HashMap;

class Dll{
    int key;
    int val;
    Dll prev;
    Dll next;
    public Dll(){
    }
    public Dll(int key,int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;
    private Dll dll;
    private HashMap<Integer,Dll> hs;
    private int cntr;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new Dll();
        this.dll.next = this.dll;
        this.dll.prev = this.dll;
        this.hs = new HashMap<>();
        this.cntr = 0;
    }

    private void update(int key){
        Dll node = hs.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = dll;
        node.next = dll.next;
        dll.next = node;
        node.next.prev = node;
        hs.put(key,node);
    }

    private void addAtHead(int key, int val){
        Dll node = new Dll(key,val);
        node.next = dll.next;
        node.prev = dll;
        dll.next = node;
        node.next.prev = node;
        hs.put(key,node);
    }

    public void deleteTail(){
        Dll lastNode = dll.prev;
        hs.remove(lastNode.key);
        lastNode.prev.next = lastNode.next;
        lastNode.next.prev = lastNode.prev;

    }

    public int get(int key) {
        if(!hs.containsKey(key)){
            return -1;
        }
        else{
            update(key);
            return hs.get(key).val;
        }
    }

    public void put(int key, int value) {
        if(hs.containsKey(key)){
            update(key);
            Dll nodetp = hs.get(key);
            nodetp.val = value;
            hs.put(key,nodetp);
        }else{
            if(cntr!=capacity){
                addAtHead(key,value);
                cntr++;
            }else{
                deleteTail();
                addAtHead(key,value);
            }
        }
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:

 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.



 Example 1:

 Input
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4
 */

