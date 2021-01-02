package weightGraph;

public class Edge {
    public int startVert;
    public int endVert;
    public int price;

    public Edge(int startVert, int endVert, int price) {
        this.startVert = startVert;
        this.endVert = endVert;
        this.price = price;
    }
}
