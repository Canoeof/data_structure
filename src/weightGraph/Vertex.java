package weightGraph;

public class Vertex {
    public char label;
    public boolean isInTree;  //Tree,该顶点在最小生成树里,反之就不在

    public Vertex(char label) {
        this.label = label;
        this.isInTree = false;
    }
}
