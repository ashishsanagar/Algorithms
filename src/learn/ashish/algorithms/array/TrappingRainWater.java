package learn.ashish.algorithms.array;

public class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     * <p>
     * Input: height = [0,1,0,1] Output: 1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 1}));
    }

    public int trap(int[] height) {
        int capacity = 0;

        if (height == null || height.length < 2)
            return capacity;


        for (int i = 1; i < height.length - 1; i++)
            capacity += capacityAtIndex(height, i);

        return capacity;
    }

    private int capacityAtIndex(int[] height, int index) {
        int maxLeft = 0;
        for (int i = index; i >= 0; i--)
            maxLeft = Math.max(maxLeft, height[i]);

        int maxRight = 0;
        for (int i = index; i < height.length; i++)
            maxRight = Math.max(maxRight, height[i]);

        return Math.min(maxRight, maxLeft) - height[index];
    }

}
