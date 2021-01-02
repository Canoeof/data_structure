package queue;

public class QueueTest3 {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(8);
        priorityQueue.insert(1);
        priorityQueue.insert(20);
        priorityQueue.insert(7);

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + "  ");
        }
    }
}

class PriorityQueue {
    private int[] elements;
    private int maxSize;
    private int nElems;

    public PriorityQueue(int size) {
        elements = new int[size];
        maxSize = size;
        nElems = 0;
    }

    //插入数据
    public void insert(int data) {
        if (nElems == 0) {
            elements[nElems++] = data;
        } else {
            int j = nElems - 1;
            while (j >= 0 && data > elements[j]) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = data;
            nElems++;
        }
    }

    //读取队头元素
    public int peek() {
        if (nElems != 0) {
            return elements[nElems - 1];
        } else {
            return -1;
        }
    }

    //删除数据
    public int remove() {
        int removeData = -1;
        if (nElems != 0) {
            removeData = elements[nElems - 1];
            elements[nElems-1] = -1;
            nElems--;
        }
        return removeData;
    }

    //判断是否为空
    public boolean isEmpty() {
        return (nElems==0);
    }
}