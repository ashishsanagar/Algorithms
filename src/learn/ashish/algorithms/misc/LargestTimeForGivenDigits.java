package learn.ashish.algorithms.misc;

public class LargestTimeForGivenDigits {
    /**
     * Input: arr = [1,2,3,4]
     * Output: "23:41"
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new LargestTimeForGivenDigits().find(arr));
    }

    public String find(int[] arr) {
        String result = "";

        if (arr == null || arr.length != 4)
            return result;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || j == k || k == i)
                        continue;

                    String hh = arr[i] + "" + arr[j];
                    String mm = arr[k] + "" + arr[6 - i - j - k];

                    if (hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && (hh + ":" + mm).compareTo(result) > 0)
                        result = hh + ":" + mm;
                }
            }
        }

        return result;
    }
}
