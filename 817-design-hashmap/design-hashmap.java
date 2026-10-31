class MyHashMap {

    private static class Node {
        int key, val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static final int SIZE = 769;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new Node(-1, -1); 
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        Node cur = buckets[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value; 
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value); 
    }

    public int get(int key) {
        Node cur = buckets[hash(key)].next;
        while (cur != null) {
            if (cur.key == key) return cur.val;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node cur = buckets[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next; 
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */