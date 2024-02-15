// Find Polygon With the Largest Perimeter

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindPolygonLargestPerimeter {

    // Approach 1
    public static long largestPerimeter1(int[] nums) {

        long totalSum = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            totalSum = totalSum + num;
        }

        int n = nums.length;

        // This code snippet iterates through an array of numbers in reverse order. It
        // subtracts each number from a running total and checks if the total is greater
        // than the current number. If so, it returns the sum of the total and the
        // current number.
        for (int i = n - 1; i >= 2; i--) {
            totalSum = totalSum - nums[i];
            if (totalSum > nums[i]) {
                return totalSum + nums[i];
            }
        }

        return -1;
    }

    // Approach 2
    public static long largestPerimeter2(int[] nums) {

        long totalSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        // This code snippet calculates the total sum of numbers in the "nums" array and
        // adds each number to a priority queue called "pq".
        for (int i : nums) {
            totalSum = totalSum + i;
            pq.add(i);
        }

        // This code snippet repeatedly removes the smallest element from a priority
        // queue until the queue is empty or has less than 3 elements. It then checks if
        // the sum of the remaining elements is greater than the removed element, and if
        // so, returns the total sum
        while (!pq.isEmpty() && pq.size() >= 3) {

            int val = pq.poll();

            if (totalSum - val > val) {
                return totalSum;
            }

            totalSum = totalSum - val;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 12, 1, 2, 5, 50, 3 };
        System.out.println("Find Polygon With the Largest Perimeter: " + largestPerimeter1(nums));
        System.out.println("Find Polygon With the Largest Perimeter: " + largestPerimeter2(nums));
    }
}
