// Furthest Building You Can Reach

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            int diff = heights[i + 1] - heights[i];

            // Skip if diff is actually a jump (getting down is free)
            if (diff <= 0) {
                continue;
            }

            // otherwise allocate ladder
            heap.offer(diff);

            // If we have used all ladders (here k is number of ladders)
            if (heap.size() > ladders) {
                bricks = bricks - heap.poll();
            }

            // If number of bricks is less than 0, we can't go further
            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5;
        int ladders = 1;
        System.out.println("Furthest Building You Can Reach: " + furthestBuilding(heights, bricks, ladders));
    }
}
