// Meeting Rooms III

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsIII {

    public static int mostBooked(int n, int[][] meetings) {

        // Counter for number of meetings held in room
        int[] rooms = new int[n];

        // List(start, end, room number)
        PriorityQueue<List<Long>> occupiedRooms = new PriorityQueue<>((x, y) -> Long.compare(x.get(1), y.get(1)));

        // 1. Each meeting will take place in the free room with the lowest number.
        PriorityQueue<Long> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add((long) i);
        }

        // 3. Meetings that have an earlier original start time should be given the room
        Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
        long currentTime = 0;

        for (int[] meeting : meetings) {
            // Update time to meeting time if meeting time is later
            currentTime = Math.max(meeting[0], currentTime);

            // If no meeting rooms left, go to time where earliest room will be cleared
            if (freeRooms.isEmpty()) {
                long earliestFreeTime = occupiedRooms.peek().get(1);
                currentTime = Math.max(earliestFreeTime, currentTime);
            }

            // Clear all rooms occurring at and before this time
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek().get(1) <= currentTime) {
                long freedRoom = occupiedRooms.poll().get(2);
                freeRooms.add(freedRoom);
            }

            // Occupy a new room,
            // 2. Delayed meeting should have same duration
            long nextRoom = freeRooms.poll();
            rooms[(int) nextRoom] += 1;
            occupiedRooms.add(List.of(currentTime, currentTime + (meeting[1] - meeting[0]), nextRoom));
        }

        // Get smallest room with largest meetings held
        int max = 0, ansRoom = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (rooms[i] >= max) {
                max = rooms[i];
                ansRoom = i;
            }
        }
        return ansRoom;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } };
        System.out.println("Meeting Rooms III: " + mostBooked(n, meetings));
    }
}