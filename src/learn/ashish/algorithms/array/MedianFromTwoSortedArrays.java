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

        if (firstArray.length > secondArray.length) {
            findMedian(secondArray, firstArray);
        }

        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        int low = 0;
        int high = firstArrayLength - 1;

        while (low <= high) {
            int partitionIndexX = low + high / 2;
            int partitionIndexY = (firstArrayLength + secondArrayLength + 1) / 2 - partitionIndexX;

            int maxLeftX = (partitionIndexX == 0) ? Integer.MIN_VALUE : firstArray[partitionIndexX - 1];
            int minRightX = (partitionIndexX == firstArrayLength) ? Integer.MAX_VALUE : firstArray[partitionIndexX];

            int maxLeftY = (partitionIndexY == 0) ? Integer.MIN_VALUE : secondArray[partitionIndexY - 1];
            int minRightY = (partitionIndexY == secondArrayLength) ? Integer.MAX_VALUE : secondArray[partitionIndexY];

            System.out.println("partitionIndexX: " + partitionIndexX + " | partitionIndexY: " + partitionIndexY);
            System.out.println("maxLeftX: " + maxLeftX + " , minRightX:" + minRightX + " | maxLeftY:" + maxLeftY + " , minRightY:" + minRightY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((firstArrayLength + secondArrayLength) % 2 == 0) {
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
                } else {
                    return (double) (Math.max(maxLeftX, maxLeftY));
                }
            } else if (maxLeftX > minRightY) {
                high = partitionIndexX + 1;

            } else {
                low = partitionIndexX - 1;
            }
        }

        return -1;
    }
}
