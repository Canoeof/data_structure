package shortpath;

public class Graph {
    //属性
    private Vertex[] vertexList;  //保存图中顶点的数组
    private int[][] adjMat;  //邻接矩阵
    private int nVerts;   //图中存在的节点的计数器
    private final int MAX_VERTS = 20;   //初始化一个图中顶点的最大个数
    private int currentVert;
    private final int INF = 1000000;
    private DirPar[] uPath;
    private int nTree;
    private int startToCurrent;  //起始点到当前点的j距离


    //构造方法
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INF;
            }
        }

        nTree = 0;
        nVerts = 0;
        uPath = new DirPar[MAX_VERTS];
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

    //最短路径算法
    public void path() {
        //选择起始节点
        int startNode = 0;
        vertexList[startNode].isInTree = true;
        nTree++;

        int tmpDis;
        for (int i = 0; i < nVerts; i++) {
            tmpDis = adjMat[startNode][i];
            uPath[i] = new DirPar(tmpDis, startNode);
        }

        while (nTree < nVerts) {
            int indexMin = getMin();  //找到距离最小的元素的下标
            int minDist = uPath[indexMin].distance;


            currentVert = indexMin;
            startToCurrent = minDist;


            vertexList[currentVert].isInTree = true;
            nTree++;

            adjustUpath();
        }

        displayPath();

        //还原标记
        nTree = 0;
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }

    public int getMin() {
        int minDist = INF;
        int indexMin = 0;
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].isInTree && uPath[i].distance < minDist) {
                minDist = uPath[i].distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    public void adjustUpath() {
        int j = 1;
        while (j < nVerts) {
            //如果扫描到的点在S集合，跳过
            if (vertexList[j].isInTree) {
                j++;
                continue;
            }

            int currentToj = adjMat[currentVert][j];
            int startToj = startToCurrent + currentToj;
            int dis = uPath[j].distance;

            if (startToj < dis) {
                uPath[j].parentVert = currentVert;
                uPath[j].distance = startToj;
            }
            j++;
        }
    }

    public void displayPath() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if (uPath[j].distance == INF) {
                System.out.print("inf");
            } else {
                System.out.print(uPath[j].distance);
            }
            char parent = vertexList[uPath[j].parentVert].label;
            System.out.print("经过点：" + parent + " ");
        }
        System.out.println();
    }
}
