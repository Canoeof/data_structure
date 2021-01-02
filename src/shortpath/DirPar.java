package shortpath;

import weightGraph.Vertex;

public class DirPar {
    public int distance;  //从起始点到当前节点的距离
    public int parentVert;  //当前节点的父节点

    public DirPar(int distance, int parentVert) {
        this.distance = distance;
        this.parentVert = parentVert;
    }


}
