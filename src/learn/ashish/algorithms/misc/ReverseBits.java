package learn.ashish.algorithms.misc;

public class ReverseBits {
    /**
     * input: 00000010100101000001111010011100
     * output: 964176192 (00111001011110000010100101000000)
     */
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(6));
    }

    public int reverseBits(int n) {
        int left = 0;
        int right = 31;
        int res = 0;

        while (left <= 31 && right >= 0) {
            if ((n & (1 << left)) != 0)
                res = res + (1 << right);

            left++;
            right--;
        }

        return res;
    }
}
