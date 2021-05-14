package learn.ashish.algorithms.array;

public class MonotonicArray {

    /**
     * array is monotonic if for any i < j, a[i] <= a[j] (increasing monotonic array)
     * or for any i > j, a[i] >= a[j] (decreasing monotonic array)
     */
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {1, 1, 3, 1, 1};
        int[] a3 = {2, 1, 1, 1};

        System.out.println(new MonotonicArray().find(a1));
        System.out.println(new MonotonicArray().find(a2));
        System.out.println(new MonotonicArray().find(a3));
    }

    public boolean find(int[] a) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) decreasing = false;
            if (a[i] > a[i + 1]) increasing = false;
        }

        return increasing || decreasing;
    }
}
