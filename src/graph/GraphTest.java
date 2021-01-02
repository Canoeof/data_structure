package graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.insert('A');
        graph.insert('B');
        graph.insert('C');
        graph.insert('D');
        graph.insert('E');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);

        graph.depthFirstSearch();
        System.out.println();
        graph.breadthFirstSearch();
    }
}
