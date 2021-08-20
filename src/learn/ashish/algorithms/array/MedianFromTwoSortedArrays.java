package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MedianFromTwoSortedArrays {

    /**
     * Find median from 2 sorted arrays
     */
    public static void main(String[] args) {
        int[] x = {1, 3, 8};
        int[] y = {2, 3, 60};
        //1,3,4,6,7,8,9,23, 67, 78, 450, 500 = (8+9) /2 = 16

        System.out.println("Median Is: " + new MedianFromTwoSortedArrays().findMedian(x, y));
    }

    public double findMedian(int[] firstArray, int[] secondArray) {
        if (firstArray.length > secondArray.length)
            return findMedian(secondArray, firstArray);

        int len1 = firstArray.length;
        int len2 = secondArray.length;

        int low = 0;
        int high = len1 - 1;

        while (low <= high) {
            int partitionIndexX = low + (high - low) / 2;
            int partitionIndexY = (len1 + len2 + 1) / 2 - partitionIndexX;

            int maxLeftX = (partitionIndexX == 0) ? Integer.MIN_VALUE : firstArray[partitionIndexX - 1];
            int minRightX = (partitionIndexX == len1) ? Integer.MAX_VALUE : firstArray[partitionIndexX];

            int maxLeftY = (partitionIndexY == 0) ? Integer.MIN_VALUE : secondArray[partitionIndexY - 1];
            int minRightY = (partitionIndexY == len2) ? Integer.MAX_VALUE : secondArray[partitionIndexY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((len1 + len2) % 2 == 0)
                    return (double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) / 2;
                else
                    return (double) Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY)
                high = partitionIndexX + 1;
            else
                low = partitionIndexX - 1;
        }

        return -1;
    }
}
