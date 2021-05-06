package learn.ashish.algorithms.misc;

public class RevenueMilestones {

    /**
     * revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
     * milestones = [100, 200, 500]
     * output = [4, 6, 10]
     */
    public static void main(String[] args) {
        int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = {100, 200, 500};

        int[] result = new RevenueMilestones().getMilestoneDays(revenues, milestones);

        for (int ele : result)
            System.out.print(ele + " ");
    }

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int i = 0;
        int j = 0;
        int k = 0;
        int current = 0;

        int[] result = new int[milestones.length];

        while (i < milestones.length) {
            if (current + revenues[j] < milestones[i])
                current += revenues[j++];
            else {
                // if revenue is greater than equal to milestone means, target achieved, add to result
                // as we are returning position in array, add 1, as array starts at 0

                result[k++] = j + 1;
                i++;
            }
        }

        return result;
    }
}
