package queue;

/**
 * 双端队列
 */
public class QueueTest2 {
    public static void main(String[] args) {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue();
        doubleEndedQueue.addFirst(1);
        doubleEndedQueue.addFirst(2);
        doubleEndedQueue.addFirst(3);
        doubleEndedQueue.addFirst(4);
        doubleEndedQueue.addFirst(5);
        doubleEndedQueue.addFirst(6);
        doubleEndedQueue.addFirst(7);
        doubleEndedQueue.addFirst(8);
        doubleEndedQueue.addFirst(9);
        doubleEndedQueue.addFirst(10);
        doubleEndedQueue.addFirst(11);
        doubleEndedQueue.addFirst(12);
        doubleEndedQueue.addFirst(13);
        doubleEndedQueue.addFirst(14);
        doubleEndedQueue.addFirst(15);
        doubleEndedQueue.addFirst(16);
        doubleEndedQueue.addFirst(17);

        while (!doubleEndedQueue.isEmpty()) {
            System.out.print(doubleEndedQueue.removeLast() + "  ");
        }
    }
}

class DoubleEndedQueue {
    private Object[] elements;
    private int maxSize;
    private int head;
    private int tail;

    public DoubleEndedQueue() {
        maxSize = 16;
        elements = new Object[maxSize];  //初始化数组长度为16个
        head = 0;
        //尾部下标指向下一个尾部元素插入的位置
        tail = 0;   //双端队列只有在空队列的时候，head==tail，添加数据之后如果再相等说明队列满了
    }

    //实现队列头部插入
    public void addFirst(Object data) {
        head = (head - 1) & (maxSize - 1);  //将头部指针向左移动一位
        elements[head] = data;
        if (head == tail) { //tail指向的是尾部插入的下一个，这个位置是空的，所以头部插入可以先进行
            this.expand();
        }
    }

    //实现尾部插入功能
    public void addLast(Object data) {
        elements[tail] = data;
        tail = (tail + 1) & (maxSize - 1);  //将尾部指针右移一位
        if (tail == head) {
            this.expand();
        }
    }

    //实现头部移除
    public Object removeFirst() {
        Object removeObj = null;
        if (head != tail) {
            removeObj = elements[head];
            elements[head] = null;
            head = (head + 1) & (maxSize - 1);
        }
        return removeObj;
    }

    //实现尾部移除
    public Object removeLast() {
        Object removeObj = null;
        if (head != tail) {
            tail = (tail - 1) & (maxSize - 1);
            removeObj = elements[tail];
            elements[tail] = null;
        }
        return removeObj;
    }

    //获取头部的元素
    public Object peekFirst() {
        if (head != tail) {
            return elements[head];
        } else {
            return null;
        }
    }

    //获取尾部元素
    public Object peekLast() {
        if (head != tail) {
            return elements[(tail - 1) & (maxSize - 1)];
        } else {
            return null;
        }
    }

    //扩容
    public void expand() {
        int newSize = maxSize << 1; //容量扩大一倍
        Object[] newObj = new Object[newSize];

        //获取前端插入的数据的个数
        int n = maxSize - head;
        //获取从后端插入的数据的个数==head

        System.arraycopy(elements, head, newObj, 0, n); //把前端插入的数据复制到新数组的最前面
        System.arraycopy(elements, 0, newObj, n, head);  //把后端插入的数据复制到新数组复制的前端数据的后面
        head = 0;
        tail = maxSize;

        this.maxSize = newSize;
        this.elements = newObj;
    }

    //获取队列的元素个数
    public int getSize() {
        return (tail - head) & (maxSize - 1);
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return (head == tail);
    }
}