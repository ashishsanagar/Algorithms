package com.ashish.algorithms.graph;

import java.util.LinkedList;

public class GraphAnalysis {

    int[] data;

    public static void main(String[] args) {
        System.out.println();

        /**
         * 0 -> 1
         * 0 -> 2
         * 2 -> 1
         * 3 -> 4
         * 4 -> 5
         * 0 -> 6
         */
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(0, 6);

        GraphAnalysis ga = new GraphAnalysis();
        ga.analyze(g);

        for (int i = 0; i < ga.data.length; i++) {
            System.out.println(i + " : " + ga.data[i]);
        }

        System.out.println("isConnected: " + ga.isConnected(0, 6));
    }

    public boolean isConnected(int src, int dest) {
        return data[src] == data[dest];
    }

    /**
     * create groups of connected graphs
     *
     * @param g
     */
    public void analyze(Graph g) {

        data = new int[g.vertices];
        int group = 0;

        for (int i = 0; i < g.vertices; i++) {
            LinkedList<Integer> list = g.adjucencyListArray[i];

            int currGroup = 0;

            for (Integer vertex : list) {
                if (data[vertex] != 0) {
                    currGroup = data[vertex];
                    break;
                }
            }

            if (currGroup == 0) {
                if (data[i] == 0) {
                    data[i] = ++group;
                    currGroup = group;
                } else {
                    currGroup = data[i];
                }
            } else {
                data[i] = currGroup;
            }

            for (Integer vertex : list) {
                data[vertex] = currGroup;
            }
        }
    }
}

class Graph {

    int vertices;
    LinkedList<Integer>[] adjucencyListArray;
    int edges;

    public Graph(int vertices) {
        this.vertices = vertices;

        adjucencyListArray = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            adjucencyListArray[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        if (src < 0 || src >= vertices || dest < 0 || dest >= vertices) {
            throw new IllegalArgumentException("invalid");
        }

        adjucencyListArray[src].addFirst(dest);
        adjucencyListArray[dest].addFirst(src);

        edges++;
    }

    public int getEdges() {
        return edges;
    }

}