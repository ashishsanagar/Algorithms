package com.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class ArraysEqual {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 3, 2, 4};

        System.out.println(new ArraysEqual().check(a, b));
    }

    boolean check(int[] a, int[] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : a)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        for (int ele : b)
            map.put(ele, map.getOrDefault(ele, 0) - 1);

        for (int ele : map.keySet()) {
            if (map.get(ele) != 0) {
                return false;
            }
        }

        return true;
    }
}
