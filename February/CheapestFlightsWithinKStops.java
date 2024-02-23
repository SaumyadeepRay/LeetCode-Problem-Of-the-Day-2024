// Cheapest Flights Within K Stops

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        // This code snippet iterates over a 2D array of flights, creating a mapping
        // where the departure city is associated with a list of arrival cities and
        // costs.
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {

            int sz = q.size();

            while (sz-- > 0) {

                int[] current = q.poll();
                int node = current[0];
                int distance = current[1];

                if (!adj.containsKey(node)) {
                    continue;
                }

                // This code snippet updates the shortest distance to neighboring nodes in a
                // graph based on the current node's distance and price, and adds the updated
                // nodes to a priority queue.
                for (int[] next : adj.get(node)) {
                    int neighbor = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbor]) {
                        continue;
                    }
                    dist[neighbor] = price + distance;
                    q.offer(new int[] { neighbor, dist[neighbor] });
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println("Cheapest Flights Within K Stops: " + findCheapestPrice(n, flights, src, dst, k));
    }
}
