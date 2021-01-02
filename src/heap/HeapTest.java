package heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.insert(55);
        heap.insert(33);
        heap.insert(66);
        heap.insert(11);
        heap.insert(22);
        heap.insert(99);
        heap.insert(8);

        heap.display();

        heap.remove();
        System.out.println();

        heap.display();
        System.out.println();

        heap.change(1, 100);
        heap.display();
    }
}

class Node {
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

//堆
class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentItems;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new Node[maxSize];
        currentItems = 0;
    }

    //判断堆是不是空的
    public boolean isEmpty() {
        return currentItems == 0;
    }

    //判断堆是不是满的
    public boolean isFull() {
       return currentItems == maxSize;
    }

    //插入新的数据
    public boolean insert(int data) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(data);
        //直接把新的节点插入到数组的末尾
        heapArray[currentItems] = newNode;
        //判断新节点是不是比父节点大，是，就把父节点上移一位
        trickleUp(currentItems++);
        return true;
    }

    //实现节点的向上筛选
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;  //拿到父节点的索引
        Node currentNode = heapArray[index];  //
        while (index > 0 && currentNode.getData() > heapArray[parent].getData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = currentNode;
    }

    //移除根节点
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentItems];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        Node top = heapArray[0];
        int largeChildIndex;
        int leftChildIndex;
        int rightChildIndex;
        while(index < currentItems/2) {  //向下移动节点的条件，必须有子节点
            //判断当前的top节点，有没有向下移动的必要
            //进一步判断，当前节点的子节点，哪个大，大的子节点和当前节点比较
            leftChildIndex = index * 2 + 1;
            rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < currentItems && heapArray[leftChildIndex].getData() < heapArray[rightChildIndex].getData()) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }

            if (top.getData() >= heapArray[largeChildIndex].getData()) {
                break;
            }

            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    //改变某个指定的节点的值
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentItems) {
            return false;
        }

        int oldValue = heapArray[index].getData();
        heapArray[index].setData(newValue);

        if (newValue > oldValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }

        return true;
    }

    public void display() {
        System.out.println("遍历堆：");
        for (int i = 0; i < currentItems; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getData() + "   ");
            } else {
                System.out.print("--");
            }
        }
    }
}
