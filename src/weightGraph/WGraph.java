package weightGraph;

public class WGraph {
    private Vertex[] vertexList;  //保存图中顶点的数组
    private int[][] adjMat;  //邻接矩阵
    private int nVerts;   //图中存在的节点的计数器
    private final int MAX_VERTS = 20;   //初始化一个图中顶点的最大个数
    private PriorityQueue priorityQueue;
    private int nTree;  //已经求解到的最小生成数的顶点的下标
    private int currentVert;
    public final int INF = 1000000;

    public WGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INF;
            }
        }

        nVerts = 0;
        priorityQueue = new PriorityQueue();
    }

    public void insert(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    //更新边
    public void addEdge(int start, int end, int price) {
        //注意：要更新两部分
        adjMat[start][end] = price;
        adjMat[end][start] = price;
    }

    //打印指定的顶点的label
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    //求解最小生成树
    public void mstw() {
        currentVert = 0;
        while (nTree < nVerts - 1) {
            vertexList[currentVert].isInTree = true;
            nTree++;

            for (int i = 0; i < nVerts; i++) {
                if(i == currentVert) continue;
                if(vertexList[i].isInTree) continue;
                int price = adjMat[currentVert][i];
                if(price == INF) continue;
                priorityQueue.insert(new Edge(currentVert,i,price));
            }

            if (priorityQueue.getSize() == 0) {
                System.out.println("当前顶点一个临界点也没有");
                return;
            }

            //删除已经在集合中的点之间的边
            for (int i = 0; i < priorityQueue.getSize(); i++) {
                if (vertexList[priorityQueue.peekN(i).startVert].isInTree && vertexList[priorityQueue.peekN(i).endVert].isInTree) {
                    priorityQueue.removeN(i);
                }
            }

            Edge minEdge = priorityQueue.removeMin();
            int startV = minEdge.startVert;
            currentVert = minEdge.endVert;

            //输出找到的边
            System.out.print(vertexList[startV].label);
            System.out.print(vertexList[currentVert].label + "  ");
        }

        //把顶点的inTree还原
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }
}
