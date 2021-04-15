package com.ashish.algorithms.graph;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        new DepthFirstSearch().dfs(graph, 1);
    }

    public void dfs(DirectedGraph graph, int startVertex) {
        boolean[] visited = new boolean[graph.numberOfVertices];

        visited[startVertex] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            System.out.print(" " + vertex);

            for (Integer adjacentVertex : graph.vertices[vertex]) {
                if (visited[adjacentVertex] == false) {
                    visited[adjacentVertex] = true;
                    stack.push(adjacentVertex);
                }
            }
        }
    }
}
