package linked;

public class OrderLinkedListTest {
    public static void main(String[] args) {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(10);
        orderLinkedList.insert(0);
        orderLinkedList.insert(103);
        orderLinkedList.insert(101);

        orderLinkedList.display();
    }
}

class OrderLinkedList{
    private Node head;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ",next=" + next + "]";
        }
    }

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
}