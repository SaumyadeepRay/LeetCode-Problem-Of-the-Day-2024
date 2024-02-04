// Minimum Window Substring

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        // base case
        if (s.length() < t.length()) {
            return "";
        }

        // String t Map
        HashMap<Character, Integer> need = new HashMap<>();
        // Substring window
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, end = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < end) {
                    start = left;
                    end = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, start + end);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }
}
