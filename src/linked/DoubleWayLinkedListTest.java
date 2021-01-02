package linked;

public class DoubleWayLinkedListTest {
    public static void main(String[] args) {

    }
}

class DoubleWayLinkedList{
    private int size;   //链表的结点数
    private Node head;  //头节点指针
    private Node tail;  //尾节点指针

    //初始化
    public DoubleWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private class Node {
        private Object data;   //封装在节点里的数据
        private Node next;   //指针，指向下一个节点
        private Node pre;  //指针，指向上一个节点

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [ data=" + data + ", next=" + next + "]";
        }
    }

    //获取节点个数
    public int getSize() {
        return size;
    }

    //向链表头添加节点
    public Object addHead(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode; //双端和单向的区别之一
            newNode.next = null;
            newNode.pre = null;
        } else {
            newNode.next = head;
            newNode.pre = null;
            head.pre = newNode;
            head = newNode;
        }
        size++;
        return newNode;
    }

    //添加尾节点
    public Object addTail(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.pre = null;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
        return  newNode;
    }

    //删除头节点
    public Object deleteHead() {
        Object obj = null;
        if (size == 0) {
            return obj;
        } else if (size == 1) {
            obj = head.data;
            head = null;
            tail = null;
            size--;
        } else {
            obj = head.data;
            head = head.next;
            head.pre = null;
            size--;
        }
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

    //删除指定的节点
    public Object delete(Object value) {
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

        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else if (current == head) {
            head = head.next;
            head.pre = null;
            size--;
        } else if (current == tail) {
            previous.next = null;
            tail = previous;
            size--;
        } else {
            previous.next = current.next;
            current.next.pre = previous;
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