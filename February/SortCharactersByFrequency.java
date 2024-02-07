// Sort Characters By Frequency

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    // Approach 1
    public static String frequencySort1(String s) {

        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // This code snippet creates a priority queue of map entries, where the entries
        // are sorted based on their integer values in descending order.
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        // The code snippet adds all the key-value pairs from a HashMap into a
        // PriorityQueue.
        pq.addAll(hm.entrySet());

        StringBuilder result = new StringBuilder();

        // This code snippet uses a priority queue to iterate through a map of
        // characters and their corresponding frequencies. It appends each character to
        // a result string, repeating it the number of times specified by its frequency.
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }

    // Approach 2
    public static String frequencySort2(String s) {

        // Step 1: Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters based on their frequency in descending order
        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));

        // Step 3: Build the result string by repeating characters according to their
        // frequency
        StringBuilder result = new StringBuilder();
        for (char c : sortedChars) {
            result.append(String.valueOf(c).repeat(charCount.get(c)));
        }

        // Step 4: Return the final sorted string
        return result.toString();
    }

    // Approach 3
    public static String frequencySort3(String s) {

        char[] str = s.toCharArray();
        int[] freq = new int[128];

        for (int i = 0; i < str.length; i++) {
            freq[str[i]]++;
        }

        for (int i = 0; i < str.length;) {

            char countMax = ',';

            for (int j = 0; j < 128; j++) {
                if (freq[j] > freq[countMax]) {
                    countMax = (char) j;
                }
            }

            while (freq[countMax] != 0) {
                str[i++] = countMax;
                freq[countMax]--;
            }
        }

        return new String(str);
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Sort Characters By Frequency: " + frequencySort1(s));
        System.out.println("Sort Characters By Frequency: " + frequencySort2(s));
        System.out.println("Sort Characters By Frequency: " + frequencySort3(s));
    }
}
