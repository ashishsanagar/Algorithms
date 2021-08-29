package learn.ashish.algorithms.graph;

import java.util.Arrays;
import java.util.Stack;

public class IsGraphBipartite {
    /**
     * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
     * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally,
     * for each v in graph[u], there is an undirected edge between node u and node v.
     * <p>
     * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
     * Output: true
     * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
     */
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(graph));

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

        System.out.println(isBipartite(graph2));
    }

    /**
     * create a color array of size of graph node. mark color to -1. visit each node and mark it with color 0 if its
     * -1. mark all its reachable nodes to opposite color of parent (e.g. 1 in this case). Do this in DFS.
     */
    private static boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len]; // holds -1, 0, 1.. if edge gets same color nodes, return false
        Arrays.fill(color, -1);

        for (int u = 0; u < len; u++) {
            if (color[u] != -1) continue;

            Stack<Integer> stack = new Stack<>();
            stack.push(u);
            color[u] = 0;

            while (!stack.isEmpty()) {
                Integer node = stack.pop();

                // go through all neighbors and mark them with opposite color of current node.
                // if color already exists and its same as parent node, return false
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = color[node] ^ 1; // flips 0-> 1 or 1-> 0  parent node
                        stack.push(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
