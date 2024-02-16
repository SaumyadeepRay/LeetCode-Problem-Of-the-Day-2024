// Least Number of Unique Integers after K Removals

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeastNumberUniqueIntegersKRemovals {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        // Map to track the frequencies of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(map.values());

        Collections.sort(frequencies);

        int count = frequencies.size();

        // This code snippet iterates through a list of frequencies. If a frequency is
        // less than or equal to a variable k, k is decreased by that frequency and
        // count is decreased by one. If a frequency is greater than k, the current
        // count is returned
        for (int i = 0; i < frequencies.size(); i++) {
            // This code snippet checks if the value at index i in the frequencies list is
            // less than or equal to k. If it is, it subtracts the value at index i from k
            // and decrements the count variable.
            if (frequencies.get(i) <= k) {
                k = k - frequencies.get(i);
                count--;
            } else {
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;
        System.out.println("Least Number of Unique Integers after K Removals: " + findLeastNumOfUniqueInts(arr, k));
    }
}
