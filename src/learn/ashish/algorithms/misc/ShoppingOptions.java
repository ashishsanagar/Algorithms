package learn.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOptions {

    /**
     * you can buy max 1 item of a type and cannot exceed budget.
     * Find all possible count of ways to purchase these items in given budget
     */
    public static void main(String[] args) {
        List<Integer> priceOfJeans = new ArrayList() {{
            add(2);
            add(4);
        }};
        List<Integer> priceOfShoes = new ArrayList() {{
            add(1);
        }};
        List<Integer> priceOfSkirts = new ArrayList() {{
            add(3);
            add(8);
        }};
        List<Integer> priceOfTops = new ArrayList() {{
            add(2);
            add(5);
        }};

        int dollars = 10;
        System.out.println(new ShoppingOptions().getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, dollars));
    }

    public int getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {
        // List<List<Integer>> options = List.of(priceOfJeans);

        List<List<Integer>> options = new ArrayList() {{
            add(priceOfJeans);
            add(priceOfShoes);
            add(priceOfSkirts);
            add(priceOfTops);
        }};

        return findWays(options, dollars);
    }

    private int findWays(List<List<Integer>> options, int budget) {
        // base case 1
        if (budget <= 0 || options.size() == 0)
            return 0;

        //base case 2
        if (options.size() == 1) {
            int interimCount = 0;

            for (int price : options.get(0))
                if (price <= budget)
                    interimCount++;

            return interimCount;
        }

        int count = 0;

        for (int price : options.get(0)) {
            if (price <= budget) {
                List<Integer> inProcess = options.get(0);
                options.remove(inProcess); // picked one price from the item, as we can have one item max,
                // remove this item and reduce budget to find if budget can be met by picking remaining items
                // note that, we can pick max one price for the item, in one purchase combination
                count += findWays(options, budget - price);

                options.add(0, inProcess);
            }
        }

        return count;
    }

}
