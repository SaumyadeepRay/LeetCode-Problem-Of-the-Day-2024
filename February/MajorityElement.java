// Majority Element

import java.util.HashMap;

public class MajorityElement {

    // Approach 1
    public static int majorityElement1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int majorElement = nums.length / 2;

        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for (int val : map.keySet()) {
            if (map.get(val) > majorElement) {
                max = Math.max(max, val);
            }
        }

        return max;
    }

    // Approach 2
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        // This code snippet finds the majority element in an array by using the
        // Boyer-Moore Voting Algorithm. It iterates through the array, keeping track of
        // a candidate element and a count. If the count becomes zero, a new candidate
        // is selected.
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("Majority Element: " + majorityElement1(nums));
        System.out.println("Majority Element: " + majorityElement2(nums));

    }
}
