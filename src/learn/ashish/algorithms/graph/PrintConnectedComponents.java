package learn.ashish.algorithms.graph;

/**
 * @author Ashish Sanagar
 */
public class PrintConnectedComponents {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(5, 6);

        new PrintConnectedComponents().print(graph);
    }

    public void print(UndirectedGraph graph) {
        if (graph == null)
            return;

        boolean[] visited = new boolean[graph.numberOfVertices];

        for (int i = 0; i < graph.numberOfVertices; i++) {
            if (!visited[i])
                bfs(graph, i, visited);
            System.out.println();
        }
    }

    private void bfs(UndirectedGraph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (Integer neighbor : graph.vertices[vertex]) {
            if (!visited[neighbor])
                bfs(graph, neighbor, visited);
        }
    }
}
