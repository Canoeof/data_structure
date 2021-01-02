package graph;

import java.util.*;

public class GraphTopo {
    //属性
    private Vertex[] vertexList;  //保存图中顶点的数组
    private int[][] adjMat;  //邻接矩阵
    private int nVerts;   //图中存在的节点的计数器
    private Stack<Integer> theStack;  //实现深度优先搜索的栈
    private Queue<Integer> theQueue;  //是西安广度优先搜索的队列
    private final int MAX_VERTS = 20;   //初始化一个图中顶点的最大个数
    private char[] sortedArray;  //保存拓扑排序后的结果

    //构造方法
    public GraphTopo() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }

        nVerts = 0;
        theStack = new Stack();
        theQueue = new LinkedList<Integer>();
        sortedArray = new char[MAX_VERTS];
    }

    //插入新的顶点
    public void insert(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    //更新边
    public void addEdge(int start, int end) {
        //注意：要更新一部分
        adjMat[start][end] = 1;
    }

    //打印指定的顶点的label
    public void displayVertex(int v) {
        System.out.print(vertexList[v].lable);
    }

    //拓扑排序
    public void topo() {
        //把顶点的个数临时保存
        int orig_nVerts = nVerts;
        while (nVerts > 0) {
            //找到没有了进一步邻接顶点的顶点,找到了返回目标顶点的下标，没有返回-1
            int currentVert = noSuccessors();
            if (currentVert == -1) {
                System.out.println("图中存在环形，不能进行拓扑排序");
                break;
            }
            sortedArray[nVerts-1] = vertexList[currentVert].lable;
            //把放到结果数组的顶点从图中删除
            deleteVertex(currentVert);
        }

        //输出排序的结果
        System.out.println("拓扑排序的结果：");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i] + "  ");
        }
    }

    //找到没有进一步邻接顶点的顶点
    public int noSuccessors() {
        boolean isAim;
        for (int row = 0; row < nVerts; row++) {
            isAim = true;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] == 1) {
                    isAim = false;
                    break;
                }
            }
            if (isAim) {
                return row;
            }
        }
        return -1;
    }

    public void deleteVertex(int v) {
        if (v != nVerts - 1) {  //要删除的节点不在数组的最后一个
            //移动
            for (int i = v; i < nVerts; i++) {
                vertexList[i] = vertexList[i + 1];
            }

            //更新邻接矩阵
            //删掉的行下面的行上移
            for (int row = v; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            //删掉的列右边的列左移
            for (int col = v; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts);
            }

            nVerts--;
        }
    }

    public void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    public void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}
