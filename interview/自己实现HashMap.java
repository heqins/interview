public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1, 1);
        hm.put(2, 2);
        System.out.println(hm.get(1)); // 1
        hm.remove(1);
        System.out.println(hm.get(1)); // -1
    }

    private final int N = 100000; // 静态数组长度100000

    private Node[] arr;

    public MyHashMap() {
        arr = new Node[N];
    }

    public void put(int key, int value) {
        int idx = hash(key);

        if (arr[idx] == null) { // 没有发生哈希碰撞
            arr[idx] = new Node(-1, -1); // 虚拟头节点
            arr[idx].next = new Node(key, value); // 实际头节点
        } else {
            Node prev = arr[idx]; // 从虚拟头开始遍历

            while (prev.next != null) {
                if (prev.next.key == key) {
                    prev.next.value = value; // 直接覆盖value
                    return;
                }
                prev = prev.next;
            }
            prev.next = new Node(key, value); // 没有键则插入节点
        }
    }

    public int get(int key) {
        int idx = hash(key);

        if (arr[idx] != null) {
            Node cur = arr[idx].next; // 从实际头节点开始寻找

            while (cur != null) {
                if (cur.key == key) {
                    return cur.value; // 找到
                }
                cur = cur.next;
            }
        }
        return -1; // 没有找到
    }

    public void remove(int key) {
        int idx = hash(key);

        if (arr[idx] != null) {
            Node prev = arr[idx];

            while (prev.next != null) {
                if (prev.next.key == key) { // 删除节点
                    Node delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                    return;
                }
                prev = prev.next;
            }
        }
    }

    // 哈希函数
    private int hash(int key) {
        return key % N;
    }

    // 链表节点
    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
