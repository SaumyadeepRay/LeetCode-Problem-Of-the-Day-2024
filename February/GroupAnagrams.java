// Group Anagrams

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] st) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();

        for (String str : st) {
            HashMap<Character, Integer> smallMap = new HashMap<>();
            for (char ch : str.toCharArray()) {
                smallMap.put(ch, smallMap.getOrDefault(ch, 0) + 1);
            }

            if (bigMap.containsKey(smallMap) == false) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                bigMap.put(smallMap, list);
            } else {
                ArrayList<String> list = bigMap.get(smallMap);
                list.add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> data : bigMap.values()) {
            ans.add(data);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] st = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Group Anagrams: " + groupAnagrams(st));
    }
}
