package learn.ashish.algorithms.array;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 0, 3, 2, 11}; // 1,3,5,11
        System.out.println(new LongestIncreasingSubsequence().find(a));
    }

    /**
     * Time: O[n^2]
     * Space: O[n]
     */
    public int find(int[] a) {
        int[] result = new int[a.length];
        result[0] = 1; // base case as for first element only that element can be added

        int longest = 0;

        // from index 1, check all previous results and chose max index and add 1
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++)
                if (a[j] < a[i])
                    result[i] = Math.max(result[j], result[i]);

            result[i] = result[i] + 1;
            longest = Math.max(longest, result[i]);
        }

        return longest;
    }
}
