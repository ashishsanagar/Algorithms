package learn.ashish.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphAnalysis {
    int[] groups;

    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(0, 6);

        GraphAnalysis ga = new GraphAnalysis();
        ga.analyze(g);

        for (int i = 0; i < ga.groups.length; i++)
            System.out.println(i + " : " + ga.groups[i]);

        System.out.println("isConnected: " + ga.isConnected(0, 6));
    }

    public boolean isConnected(int src, int dest) {
        return groups[src] == groups[dest];
    }

    /**
     * create groups of connected graphs
     */
    public void analyze(UndirectedGraph g) {
        groups = new int[g.numberOfVertices];
        Arrays.fill(groups, -1);

        int group = 0;

        for (int vertex = 0; vertex < g.numberOfVertices; vertex++) {
            LinkedList<Integer> neighbors = g.vertices[vertex];

            int currGroup = groups[vertex];

            for (Integer neighbor : neighbors) {
                if (groups[neighbor] != -1) {
                    currGroup = groups[neighbor];
                    break;
                }
            }

            if (currGroup == -1) {
                groups[vertex] = ++group;
                currGroup = group;
            } else {
                groups[vertex] = currGroup;
            }

            for (Integer neighbor : neighbors)
                groups[neighbor] = currGroup;
        }
    }
}
