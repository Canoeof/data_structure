package linked;

import jdk.swing.interop.SwingInterOpUtils;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");
        //打印链表
        singleLinkedList.display();
        //删除节点
        singleLinkedList.delete("C");
        singleLinkedList.display();
    }
}

class SingleLinkedList{
    private int size;  //链表的节点数
    private Node head;   //

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;   //封装在节点里的数据
        private Node next;   //指针，指向下一个节点

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [ data=" + data + ", next=" + next + "]";
        }
    }

    //向链表头添加节点
    public Object addHead(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }

    //在链表头删除节点
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定数据对应的节点
    public Node find(Object data) {
        Node current = head;
        int tmpSize = size;
        while (tmpSize > 0) {
            if (data.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tmpSize--;
        }
        return null;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //删除指定的节点，删除成功返回true,失败返回false
    public boolean delete(Object value) {
        if (isEmpty()) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (!value.equals(current.data)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
        return true;
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

