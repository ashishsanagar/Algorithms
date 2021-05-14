package learn.ashish.algorithms.graph;

import java.util.LinkedList;

/**
 * @author Ashish Sanagar
 */
public class UndirectedGraph {
    int numberOfVertices;
    LinkedList<Integer>[] vertices;

    public UndirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        vertices = new LinkedList[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++)
            vertices[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        graph.printGraph();
    }

    public void addEdge(int src, int dest) {
        vertices[src].addFirst(dest);
        vertices[dest].addFirst(src);
    }

    public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print("Vertex: " + i);

            for (Integer vertex : vertices[i])
                System.out.print(" -> " + vertex);

            System.out.println();
        }
    }
}
