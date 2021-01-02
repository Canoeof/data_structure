package weightGraph;

public class WGraphTest {
    public static void main(String[] args) {
        WGraph wGraph = new WGraph();
        wGraph.insert('A');
        wGraph.insert('B');
        wGraph.insert('C');
        wGraph.insert('D');
        wGraph.insert('E');
        wGraph.insert('F');

        wGraph.addEdge(0, 1, 6);
        wGraph.addEdge(0, 3, 4);
        wGraph.addEdge(1, 2, 10);
        wGraph.addEdge(1, 3, 7);
        wGraph.addEdge(1, 4, 7);
        wGraph.addEdge(2, 3, 8);
        wGraph.addEdge(2, 4, 5);
        wGraph.addEdge(2, 5, 6);
        wGraph.addEdge(3, 4, 12);
        wGraph.addEdge(4, 5, 7);

        wGraph.mstw();
    }
}
