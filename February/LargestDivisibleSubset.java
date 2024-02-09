// Largest Divisible Subset

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        // The code snippet initializes an integer variable "n" with the length of the
        // "nums" array. It then creates a new integer array "dp" with the same length
        // as "nums" and fills it with 1. Finally, it sorts the
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        // This code snippet finds the longest increasing subsequence in an array by
        // iterating through each element and checking if it is divisible by any
        // previous element. It keeps track of the maximum subsequence length and its
        // index.
        int maxSize = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        // The code snippet creates a new list called "result" and initializes it as an
        // empty ArrayList. It then iterates through a given array "nums" starting from
        // the index "maxIndex" and checks if the current number is divisible by the
        // number at
        List<Integer> result = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                result.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 8, 10, 240 };
        System.out.println("Largest Divisible Subset: " + largestDivisibleSubset(nums));
    }
}
