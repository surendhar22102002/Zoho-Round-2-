public class ReverseSubstringBetweenTwoCharacters {
    static void main() {
        String s = "abcdefg";
        char c1 = 'c';
        char c2 = 'f';

        System.out.println(reverseSubstring(s, c1, c2));
    }

    public static String reverseSubstring(String s, char a, char b) {
        char[] arr = s.toCharArray();
        int start = -1;
        int end = -1;

        //  find first a and first b
        for (int i = 0; i < s.length(); i++) {
            if (start == -1 && s.charAt(i) == a) {
                start = i;
            }

            if (s.charAt(i) == b) {
                end = i;
                break;
            }
        }

        // if not found or wrong
        if (start == -1 || end == -1 || start > end) {
            return s;
        }

        // Reverse
        int left = start, right = end;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }

        return result.toString();
    }
}
