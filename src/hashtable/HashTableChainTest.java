package hashtable;

public class HashTableChainTest {
    public static void main(String[] args) {
        HashTableChain hashTableChain = new HashTableChain(6);
        hashTableChain.insert(12);
        hashTableChain.insert(200);
        hashTableChain.insert(33);
        hashTableChain.insert(23);
        hashTableChain.insert(145);

        hashTableChain.display();
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ",next=" + next + "]";
    }
}

class OrderLinkedList{
    private Node head;
    private int size;

    public OrderLinkedList() {
        head = null;
        size = 0;
    }

    //有序链表插入操作
    public void insert(int data) {
        Node newNode = new Node(data);
        Node previous = null;
        Node current = head;
        while (current != null && data > current.data) {
            previous =  current;
            current = current.next;
        }

        if (previous == null) {
            head = newNode;
            head.next = current;
        } else {
            newNode.next = current;
            previous.next = newNode;
        }
        size++;
    }

    //删除头节点
    public int deleteHead() {
        int i = head.data;
        head = head.next;
        return i;
    }

    //循环遍历输出所有Node信息
    public void display() {
        if (size > 0) {
            Node current = head;
            int tmpSize = size;
            if (tmpSize == 1) {
                System.out.print("[" + head + "]");
                return;
            }
            while (tmpSize > 0) {
                if (current == head) {
                    System.out.print("[" + current.data + "->");
                } else if (current.next == null) {
                    System.out.print(current.data + "]");
                } else {
                    System.out.print(current.data + "->");
                }
                tmpSize--;
                current = current.next;
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public Node find(int data) {
        Node current = head;
        while (current != null && current.data <= data) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(int data) {
        Node previous = null;
        Node current = head;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current != null && previous == null) {
            head = head.next;
        }
        if (current != null && previous != null) {
            previous.next = current.next;
        }
    }
}

class HashTableChain {
    private OrderLinkedList[] hashArray;
    private int arraySize;

    public HashTableChain(int size) {
        this.arraySize = size;
        hashArray = new OrderLinkedList[arraySize];

        //对hashArray数组里的元素初始化进入一个空的链表
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new OrderLinkedList();
        }
    }

    //hash表的显示
    public void display() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println("第" + i + "个数组元素项:");
            hashArray[i].display();
        }
    }

    //哈希函数
    public int hashFunction(int data) {
        return data % arraySize;
    }

    //实现哈希表的插入
    public void insert(int data) {
        int hashval = hashFunction(data);
        hashArray[hashval].insert(data);
    }

    //删除
    public void delete(int data) {
        int hashval = hashFunction(data);
        hashArray[hashval].delete(data);
    }

    //查找
    public Node find(int data) {
        int hashval = hashFunction(data);
        return hashArray[hashval].find(data);
    }

}

