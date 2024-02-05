// First Unique Character in a String

import java.util.HashMap;

public class FirstUniqueCharacterString {

    public static int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return s.indexOf(ch);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("First Unique Character in a String: " + firstUniqChar(s));
    }
}
