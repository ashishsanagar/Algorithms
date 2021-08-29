package learn.ashish.algorithms.array;

public class StairsNumberOfWays {

    /**
     * find count of number of ways nth stair can be reached if at a time one or two steps are taken
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new StairsNumberOfWays().count(n));
    }

    public int count(int n) {
        int[] result = new int[n + 1];
        result[0] = 1; //0th step has 1 way
        result[1] = 1; //1st step has 1 way

        // nth step got (n-1)th + (n-2)th ways
        for (int i = 2; i < result.length; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }
}
