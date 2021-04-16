package learn.ashish.algorithms.misc;

public class BillionUsersGrowth {


    int billion = 1000000000;

    /**
     * growthRates = [1.1, 1.2, 1.3]
     * output = 79
     *
     * @param args
     */
    public static void main(String[] args) {
        float[] growthRates = {(float) 1.1, (float) 1.2, (float) 1.3};
        System.out.println(new BillionUsersGrowth().getBillionUsersDay(growthRates));
    }

    private int calculateUsers(float[] rates, int days) {
        int users = 0;

        for (float rate : rates) {
            users += Math.pow(rate, days);
        }

        return (int) users;
    }

    private int binarySearch(int low, int high, float[] rates) {
        while (low <= high) {
            int mid = (low + high) / 2;

            int users = calculateUsers(rates, mid);

            if (users < billion) {
                low = mid + 1;
            } else if (users > billion) {
                high = mid - 1;
            } else {
                break;
            }
        }

        return low;
    }

    int getBillionUsersDay(float[] growthRates) {
        return binarySearch(1, Integer.MAX_VALUE, growthRates);
    }


}
