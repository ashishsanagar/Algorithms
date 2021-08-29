package learn.ashish.algorithms.array;

import java.util.TreeMap;

public class MaxPopulationYear {

    /**
     * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years
     * of the ith person.
     * <p>
     * Input: logs = [[1993,1999],[2000,2010]]
     * Output: 1993
     * Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
     */
    public static void main(String[] args) {
        int[][] logs = new int[][]{{1993, 1999}, {2000, 2010}};
        System.out.println(new MaxPopulationYear().maximumPopulation(logs));
    }

    public int maximumPopulation(int[][] logs) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] log : logs) {
            int birthYear = log[0];
            int deathYear = log[1];

            map.put(birthYear, map.getOrDefault(birthYear, 0) + 1);
            map.put(deathYear, map.getOrDefault(deathYear, 0) - 1);
        }

        int max = 0;
        int current = 0;
        int year = -1;
        for (int key : map.keySet()) {
            current += map.get(key);

            if (current > max) {
                year = key;
                max = current;
            }
        }

        return year;
    }

}
