// Greatest Common Divisor Traversal

import java.util.Arrays;

public class GreatestCommonDivisorTraversal {

    public static boolean canTraverseAllPairs(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int maxElement = Arrays.stream(nums).max().getAsInt();

        if (Arrays.stream(nums).min().getAsInt() == 1) {
            return false;
        }

        int[] factorArray = factorsCalculator(maxElement);
        int[] parent = new int[maxElement + 1];
        int[] rank = new int[maxElement + 1];

        // This code initializes two arrays, `parent` and `rank`, with values
        // corresponding to their indices, and sets all elements in the `rank` array to
        // 1.
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // The code iterates through each number in an array, factors the number, and
        // performs a union operation on the factors with the parent and rank arrays.
        for (int num : nums) {
            int x = num;
            // This snippet iterates through factors of x, performs a union operation, and
            // divides x by its factors until x is no longer greater than 1.
            while (x > 1) {
                int p = factorArray[x];
                union(parent, rank, p, num);
                // This code snippet divides the variable x by the variable p as long as x is
                // divisible by p without any remainder.
                while (x % p == 0) {
                    x = x / p;
                }
            }
        }

        int p = find(parent, nums[0]);
        
        // This code iterates through an array and checks if a specific element is found
        // in a parent array. If not found, it returns false.
        for (int i = 1; i < nums.length; i++) {
            if (find(parent, nums[i]) != p) {
                return false;
            }
        }

        return true;
    }

    // This function calculates the smallest prime factor for each number up to a
    // given integer n and stores the results in an array.
    private static int[] factorsCalculator(int n) {
        int[] dp = new int[n + 2];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        // This code snippet finds prime factors for numbers up to n using the Sieve of
        // Eratosthenes algorithm.
        for (int i = 2; i <= n; i++) {
            if (dp[i] == i) {
                for (int j = i * 2; j <= n; j += i) {
                    if (dp[j] == j) {
                        dp[j] = i;
                    }
                }
            }
        }
        return dp;
    }

    // This function finds the root parent of an element in a disjoint set data
    // structure using path compression technique.
    private static int find(int[] parent, int a) {
        return parent[a] = parent[a] == a ? a : find(parent, parent[a]);
    }

    // This function performs the union operation on two elements in a disjoint-set
    // data structure by merging the sets that contain the elements with path
    // compression and union by rank optimizations.
    private static void union(int[] parent, int[] rank, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        // Base Case
        if (a == b) {
            return;
        }
        // Swaps the values of variables `a` and `b` if the value of `rank[a]` is less
        // than the value of `rank[b]`.
        if (rank[a] < rank[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        rank[a] += rank[b];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 12, 8 };
        System.out.println("Greatest Common Divisor Traversal: " + canTraverseAllPairs(nums));
    }
}
