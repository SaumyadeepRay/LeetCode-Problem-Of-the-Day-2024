// Find All People With Secret

import java.util.ArrayList;
import java.util.List;

public class FindAllPeopleWithSecret {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        int maxMeetTime = 0;

        // This code iterates through an array of meetings and finds the maximum meeting
        // time by comparing each meeting's duration with the current maximum.
        for (int i = 0; i < meetings.length; i++) {
            maxMeetTime = Math.max(maxMeetTime, meetings[i][2]);
        }

        List<List<int[]>> list = new ArrayList<List<int[]>>();
        // This code initializes a list of lists, where each inner list contains arrays
        // of integers. The number of inner lists is determined by the value of
        // `maxMeetTime`.
        for (int i = 0; i <= maxMeetTime; i++) {
            list.add(new ArrayList<int[]>());
        }

        // This code iterates through a list of meetings, extracts their start and end
        // times, and adds them to another list based on their time slot.
        for (int i = 0; i < meetings.length; i++) {
            int time = meetings[i][2];
            int a = meetings[i][0];
            int b = meetings[i][1];

            list.get(time).add(new int[] { a, b });
        }

        int parent[] = new int[n];

        // This code initializes each element in the array "parent" with its
        // corresponding index value starting from 0.
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        parent[firstPerson] = 0;

        // This code iterates through a list of arrays, performs union and find
        // operations on elements within the arrays, and updates the parent array based
        // on the operations.
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).size() == 0) {
                continue;
            }

            // Iterates through a list of arrays, extracts two integers from each array, and
            // performs a union operation on them using the function "union" with a given
            // parent array.
            for (int j = 0; j < list.get(i).size(); j++) {
                int a = list.get(i).get(j)[0];
                int b = list.get(i).get(j)[1];

                union(a, b, parent);
            }

            // This code iterates through a list of pairs, finds their parents, and updates
            // the parent array based on the values of the pairs.
            for (int j = 0; j < list.get(i).size(); j++) {
                int a = list.get(i).get(j)[0];
                int b = list.get(i).get(j)[1];
                find(a, parent);
                find(b, parent);

                if (parent[a] != 0) {
                    parent[a] = a;
                }

                if (parent[b] != 0) {
                    parent[b] = b;
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        // The code iterates through an array, calling a function on each element. If
        // the element is equal to 0, it is added to a result list.
        for (int i = 0; i < parent.length; i++) {

            find(i, parent);

            if (parent[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

    // This function finds the root parent of a given element in a parent array
    // using recursion and path compression technique.
    private static int find(int a, int[] parent) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a], parent);
    }

    // This function performs a union operation on two elements in a set represented
    // by an array, updating the parent pointers to merge the sets if they are not
    // already in the same set.
    private static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if (a != b) {
            if (a <= b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } };
        int firstPerson = 1;
        System.out.println("Find All People With Secret: " + findAllPeople(n, meetings, firstPerson));
    }
}
