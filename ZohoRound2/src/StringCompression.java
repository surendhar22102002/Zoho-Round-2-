import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    static void main() {
        char[] ch = {'a','a','b','b','c','c','c'};
        System.out.println(compress2(ch));
    }



    // Solution 1
    // TC = O(n)  SC = O(n)
    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }


        StringBuilder sb = new StringBuilder();

        char prev = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];

            if (prev != ch) {
                if (count > 1) {
                    sb.append(prev);
                    String st = String.valueOf(count);
                    sb.append(st);
                } else {
                    sb.append(prev);
                }
                prev = ch;
                count = 1;
            } else  {
                count++;
            }
        }

        if (count > 1) {
            sb.append(prev);
            String st = String.valueOf(count);
            sb.append(st);
        } else {
            sb.append(prev);
        }

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            chars[i] = ch;
        }

        return sb.length();
    }

    // solution 2

    public static int compress2(char[] chars) {
        // int[] map = new int[256];
        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int val = m.getValue();

            if (val > 1) {
                sb.append(key);
                sb.append(val);
            } else {
                sb.append(key);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            chars[i] = ch;
        }

        return sb.length();
    }
}
