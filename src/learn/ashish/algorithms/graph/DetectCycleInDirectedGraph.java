package learn.ashish.algorithms.graph;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInDirectedGraph {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
     * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * <p>
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
     * So it is impossible.
     * <p>
     * Note: intuitive solution is to detect cycle in the graph.. if there is acycle. courses cannot be completed
     */
    public static void main(String[] args) {
        int[][] prerequisites_1 = new int[][]{{1, 0}};
        int[][] prerequisites_2 = new int[][]{{1, 0}, {0, 1}};

        System.out.println(new DetectCycleInDirectedGraph().canFinish(2, prerequisites_1));
        System.out.println(new DetectCycleInDirectedGraph().canFinish(2, prerequisites_2));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        DirectedGraph g = new DirectedGraph(numCourses);

        for (int[] cond : prerequisites)
            g.addEdge(cond[1], cond[0]);

        // if cycle exists in the graph, cources cannot be cimpleted
        if (detectCycle(g))
            return false;

        return true;
    }

    private boolean detectCycle(DirectedGraph g) {
        Set<Integer> notVisited = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < g.numberOfVertices; i++) {
            notVisited.add(i);
        }

        while (notVisited.size() > 0) {
            if (isCyclic(g, notVisited.iterator().next(), notVisited, visiting, visited))
                return true;
        }

        return false;
    }

    private void moveVertex(Integer u, Set<Integer> from, Set<Integer> to) {
        from.remove(u);
        to.add(u);
    }

    private boolean isCyclic(DirectedGraph g, int u, Set<Integer> notVisited, Set<Integer> visiting, Set<Integer> visited) {
        moveVertex(u, notVisited, visiting);

        for (int v : g.vertices[u]) {
            if (visited.contains(v))
                continue;
            if (visiting.contains(v))
                return true;
            if (isCyclic(g, v, notVisited, visiting, visited))
                return true;
        }

        moveVertex(u, visiting, visited);
        return false;
    }
}
