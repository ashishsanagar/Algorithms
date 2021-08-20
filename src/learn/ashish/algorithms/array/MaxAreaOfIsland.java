package learn.ashish.algorithms.array;

public class MaxAreaOfIsland {

    /**
     * 1 0 1 1
     * 0 1 1 0
     * 1 0 1 1
     * 1 0 1 0
     * <p>
     * if element is 1, then we found iland. if vertical or horizonal element is 1 then count in area of island.
     * Diagonal 1's are not counted
     * <p>
     * In example above, max area is 7
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 0}};

        System.out.println(new MaxAreaOfIsland().find(grid));
    }

    public int find(int[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0)
            return max;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int count = 1;

        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);

        return count;
    }
}
