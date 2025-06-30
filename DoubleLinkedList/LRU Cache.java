class LRUCache {
    class DoubleLinkedList {
         Node head;
         Node tail;
         Map<Integer,Node> map;
         int capacity;
        public DoubleLinkedList(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            head.prev = null;
            tail.prev = head;
            tail.next = null;
            head.val = -1;
            tail.val = -1;
        }
        public void remove(int key) {
               Node node1 = map.get(key);
                node1.prev.next = node1.next;
                node1.next.prev = node1.prev; 
                map.remove(key);
        }
        public void put(int key,int value) {
            if(!map.containsKey(key) && map.size() >= this.capacity) {
                int key1= tail.prev.key;
                this.remove(key1);
            }
            if(map.containsKey(key)) {
                Node node1 = map.get(key);
                node1.prev.next = node1.next;
                node1.next.prev = node1.prev; 
                map.remove(key);
            }
            Node node = new Node();
            node.val = value;
            node.key = key;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            map.put(key,node);
        }
        public int get(int key) {
           
            if(map.containsKey(key)) {
                int value = map.get(key).val;
                 this.put(key,value);
                return map.get(key).val;
            }
            return -1;
        }

    }
    class Node {
        Node prev;
        Node next;
        int val;
        int key;
    }
    int size;
    DoubleLinkedList doubleLinkedList;
    public LRUCache(int capacity) {
        size = capacity;
        doubleLinkedList =new DoubleLinkedList(size);
    }
    public int get(int key) {
        return doubleLinkedList.get(key);
    }
    public void put(int key, int value) {
        this.doubleLinkedList.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
