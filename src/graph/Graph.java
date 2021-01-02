package graph;

import java.util.*;

/**
 * 封装图的类
 */
public class Graph {
    //属性
    private Vertex[] vertexList;  //保存图中顶点的数组
    private int[][] adjMat;  //邻接矩阵
    private int nVerts;   //图中存在的节点的计数器
    private Stack<Integer> theStack;  //实现深度优先搜索的栈
    private Queue<Integer> theQueue;  //是西安广度优先搜索的队列
    private final int MAX_VERTS = 20;   //初始化一个图中顶点的最大个数

    //构造方法
    public Graph() {
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
    }

    //插入新的顶点
    public void insert(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    //更新边
    public void addEdge(int start, int end) {
        //注意：要更新两部分
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //打印指定的顶点的label
    public void displayVertex(int v) {
        System.out.print(vertexList[v].lable);
    }

    //深度优先搜索
    public void depthFirstSearch() {
        //首先访问顶点中的第一个
        vertexList[0].isVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            //拿到当前顶点的下标
            int currentVert = theStack.peek();
            //找到当前顶点的其他没有访问过的邻接顶点
            int v = getAdjUnVisited(currentVert);
            if (v == -1) {  //当前顶点没有未被访问的邻接顶点
                theStack.pop();
            } else {
                vertexList[v].isVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //还原所有顶点的isVisited标记
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isVisited = false;
        }
    }

    //找到当前顶点的其他未被访问过的邻接顶点
    public int getAdjUnVisited(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    //广度优先搜索
    public void breadthFirstSearch() {
        vertexList[0].isVisited = true;
        displayVertex(0);
        theQueue.add(0);
        int v1;
        int v2;
        while (!theQueue.isEmpty()) {
            v1 = theQueue.remove();
            while ((v2 = getAdjUnVisited(v1)) != -1) {
                vertexList[v2].isVisited = true;
                displayVertex(v2);
                theQueue.add(v2);
            }
        }
        //还原所有顶点的isVisited标记
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isVisited = false;
        }
    }

}
