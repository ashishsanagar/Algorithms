package learn.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArray {

    /**
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new SubsetsOfArray().find(nums);

        for (List<Integer> list : subsets) {
            for (Integer num : list) {
                System.out.print(num + " ,");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> find(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        generate(nums, 0, new ArrayList<Integer>(), subsets);

        return subsets;
    }

    public void generate(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generate(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

}
