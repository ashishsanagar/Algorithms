package learn.ashish.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    /**
     * In directed acyclic graph sort vertices by dependency order. if a -> b then a should come before b
     *
     * @param args
     */
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(8);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);

        List<Integer> sorted = new TopologicalSort().sort(graph);

        for (int vertex : sorted)
            System.out.print(vertex + " -> ");
        //6 -> 5 -> 7 -> 2 -> 1 -> 3 -> 4 -> 0 ->
    }

    public List<Integer> sort(DirectedGraph graph) {
        List<Integer> sorted = new ArrayList<>();
        boolean[] visited = new boolean[graph.numberOfVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.numberOfVertices; i++) {
            if (!visited[i])
                topSort(graph, i, visited, stack);
        }

        while (!stack.isEmpty())
            sorted.add(stack.pop());

        return sorted;
    }

    private void topSort(DirectedGraph graph, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int neighbor : graph.vertices[vertex]) {
            if (!visited[neighbor])
                topSort(graph, neighbor, visited, stack);
        }

        stack.push(vertex);
    }
}
