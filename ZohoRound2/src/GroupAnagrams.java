import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    static void main() {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            char[] ch = new char[26];

            for (char c : s.toCharArray()) {
                ch[c - 'a']++;
            }

            String key = Arrays.toString(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
