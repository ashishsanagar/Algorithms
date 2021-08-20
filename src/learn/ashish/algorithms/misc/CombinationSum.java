package learn.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     * <p>
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * <p>
     * Return a list of all possible valid combinations. The list must not contain the same combination twice,
     * and the combinations may be returned in any order.
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     */
    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().find(3, 9);

        for (List<Integer> list : result)
            System.out.println(list.toString());
    }

    public List<List<Integer>> find(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        recurse(1, new ArrayList<>(), result, n, k);
        return result;
    }

    private void recurse(int index, List<Integer> curr, List<List<Integer>> result, int n, int k) {
        if (curr.size() == k && n == 0)
            result.add(new ArrayList<>(curr));

        for (int i = index; i <= 9; i++) {
            curr.add(i);
            recurse(i + 1, curr, result, n - i, k);
            curr.remove(curr.size() - 1);
        }
    }
}
