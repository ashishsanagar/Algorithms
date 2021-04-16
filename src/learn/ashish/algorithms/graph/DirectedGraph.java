package learn.ashish.algorithms.graph;

import java.util.LinkedList;

/**
 * @author Ashish Sanagar
 */
public class DirectedGraph {
    int numberOfVertices;
    LinkedList<Integer>[] vertices;

    public DirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        vertices = new LinkedList[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            vertices[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);

        graph.printGraph();
    }

    public void addEdge(int src, int dest) {
        vertices[src].addFirst(dest);
    }

    public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print("Vertex: " + i);
            for (Integer vertex : vertices[i]) {
                System.out.print(" -> " + vertex);
            }

            System.out.println();
        }
    }
}
