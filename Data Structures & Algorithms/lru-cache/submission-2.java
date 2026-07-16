class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(-100, -100);
        tail = new Node(-200, -200);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node n = map.get(key);
        delete(n);
        addAtEnd(n);

        return n.value;
    }
  
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            delete(map.get(key));
            
        }
        else if(map.size() >= capacity) {
            map.remove(head.next.key);
            delete(head.next);
        }

        Node newNode = new Node(key, value);
        addAtEnd(newNode);
        map.put(key, newNode);
    }

    private void delete(Node n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    private void addAtEnd(Node n) {
        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;
    }
}
