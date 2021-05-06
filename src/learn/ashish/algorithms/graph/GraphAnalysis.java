package learn.ashish.algorithms.graph;

import java.util.LinkedList;

public class GraphAnalysis {
    int[] data;

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

        for (int i = 0; i < ga.data.length; i++)
            System.out.println(i + " : " + ga.data[i]);

        System.out.println("isConnected: " + ga.isConnected(0, 6));
    }

    public boolean isConnected(int src, int dest) {
        return data[src] == data[dest];
    }

    /**
     * create groups of connected graphs
     */
    public void analyze(UndirectedGraph g) {
        data = new int[g.numberOfVertices];
        int group = 0;

        for (int i = 0; i < g.numberOfVertices; i++) {
            LinkedList<Integer> vertices = g.vertices[i];

            int currGroup = data[i];

            for (Integer vertex : vertices) {
                if (data[vertex] != 0) {
                    currGroup = data[vertex];
                    break;
                }
            }

            if (currGroup == 0) {
                data[i] = ++group;
                currGroup = group;
            } else
                data[i] = currGroup;

            for (Integer vertex : vertices)
                data[vertex] = currGroup;
        }
    }
}
