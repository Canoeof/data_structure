package queue;

/**
 * 实现自己的队列
 */
public class QueueTest1 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);

        System.out.println(myQueue.peek());

        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.remove());
        }
    }
}

class MyQueue{
    private Object[] elemData;
    private int maxSize;   //数组最大长度
    private int rear;      //队尾指针
    private int front;     //队头指针
    private int nElems;    //当前元素个数

    //初始化
    public MyQueue(int size) {
        this.maxSize = size;
        elemData = new Object[size];
        rear = -1;
        front = 0;
        nElems = 0;
    }

    //插入数据元素
    public void insert(Object data) {
        //判断队满与否
        if (nElems == maxSize) {
            System.out.println("队列已满，新的数据项无法插入");
        } else {
            if ((rear + 1) == maxSize) rear = -1;
            elemData[++rear] = data;
            nElems++;
        }
    }

    //查看队列队头的数据项
    public Object peek() {
        //判断队列是否为空
        if (nElems == 0) {
            return null;
        }
        return elemData[front];
    }

    //出队
    public Object remove() {
        Object removeObj = null;
        if (nElems != 0) {
            removeObj = elemData[front];
            elemData[front] = null;
            nElems--;
            if (front == (maxSize - 1)) {
                front = 0;
            } else {
                front++;
            }
        }
        return removeObj;
    }

    //判断队列是不是空队列
    public boolean isEmpty() {
        return (nElems == 0);
    }

    //判断队列是不是满的
    public boolean isFull() {
        return (nElems == maxSize);
    }

    //返回队列大小
    public int getSize() {
        return nElems;
    }
}