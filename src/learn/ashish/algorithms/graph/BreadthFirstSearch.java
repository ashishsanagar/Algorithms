package learn.ashish.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ashish Sanagar
 */
public class BreadthFirstSearch {

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

        new BreadthFirstSearch().bfs(graph, 1);
    }

    public void bfs(DirectedGraph graph, int startVertex) {
        int numberOfVertices = graph.numberOfVertices;

        boolean[] visited = new boolean[numberOfVertices];
        visited[startVertex] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.print(" " + vertex);

            for (Integer adjacentVertex : graph.vertices[vertex]) {
                if (visited[adjacentVertex] == false) {
                    queue.add(adjacentVertex);
                    visited[adjacentVertex] = true;
                }
            }
        }
    }
}
