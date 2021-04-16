package learn.ashish.algorithms.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ashish Sanagar
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 8};
        int[] b = {1, 2, 3, 4};

        mergeTwoSortedArrays(a, b);

        //variation maxLength only non duplicates
        mergeAndPrintOnlyNonDuplicates(a, b);
    }

    private static void mergeAndPrintOnlyNonDuplicates(int[] a, int[] b) {

        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] < b[j]) {
                set.add(a[i]);
                i++;
            } else {
                set.add(b[j]);
                j++;
            }
        }

        if (i < a.length) {
            for (int k = i; k < a.length; k++) {
                set.add(a[k]);
            }
        }

        if (j < b.length) {
            for (int k = i; k < b.length; k++) {
                set.add(b[k]);
            }
        }
        System.out.println("\nnon dups: ");
        for (Integer ele : set) {
            System.out.print(ele + " ");
        }
    }

    private static void mergeTwoSortedArrays(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();

        for (Integer ele : a) {
            set.add(ele);
        }

        for (Integer ele : b) {
            set.add(ele);
        }

        for (Integer ele : set) {
            System.out.print(ele + " ");
        }
    }
}
