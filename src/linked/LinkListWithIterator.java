package linked;

import java.util.Iterator;

public class LinkListWithIterator<T> implements LIstWithIteratorInterface<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private T data;
        private Node next;

        //初始化节点
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [ data=" + data + ", next=" + next + "]";
        }
    }

    public LinkListWithIterator() {
        super();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void addHead(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addTail(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //以内部类的形式定义迭代器
    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;

        public IteratorForLinkedList() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node rs = nextNode;
                nextNode = nextNode.next;
                return rs.data;
            }
            return null;
        }
    }

    @Override
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }
}
