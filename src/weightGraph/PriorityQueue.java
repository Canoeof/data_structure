package weightGraph;

public class PriorityQueue {
    private Edge[] edges;  //有序，从大到小
    private final int MAX_SIZE = 20;
    private int size;  //真实保存的边的条数

    public PriorityQueue() {
        edges = new Edge[MAX_SIZE];
        size = 0;
    }

    //向队列中插入新的边
    public void insert(Edge edge) {  //从小到大有序插入
        int i;
        for (i = 0; i < size; i++) {
            if (edge.price >= edges[i].price) {
                break;
            }
        }
        for (int j = size - 1; j >= i; j--) {
            edges[j + 1] = edges[j];
        }
        edges[i] = edge;
        size++;
    }

    //删除并获取队列中的最小的权的边
    public Edge removeMin() {
        return edges[--size];
    }

    //删除指定下标的边
    public void removeN(int n) {
        for (int i = n; i < size; i++) {
            edges[i] = edges[i + 1];
        }
        size--;
    }

    //获取权重最小的边
    public Edge peekMin() {
        return edges[size - 1];
    }

    //判断队列是不是空
    public boolean isEmpty() {
        return size == 0;
    }

    //获取队列中元素的个数
    public int getSize() {
        return size;
    }

    //获取指定下标的边
    public Edge peekN(int n) {
        return edges[n];
    }

}
