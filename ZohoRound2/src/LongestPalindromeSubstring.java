import java.util.Arrays;

public class LongestPalindromeSubstring {
    static void main() {
        String input = "babd";
        System.out.println(palindromeSubstring2(input));
    }


    // TC = O(n^3)
    // SC = O(n)
    public static String palindromeSubstring(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s,i,j)){
                    int length = j - i + 1;
                    if (length > str.length()) {
                        str = new StringBuilder(s.substring(i, j + 1));
                    }
                };
            }
        }
        return str.toString();
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // TC = O(n^2)
    // SC = O(1)
    public static String palindromeSubstring2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = s.length() -1;


        while (start <= end) {
            // check hole
            if (isPalindrome(s, start, end)) {
                return s.substring(start, end+1);
            }

            // check start + 1
            if (isPalindrome(s, start + 1, end)) {
                return s.substring(start + 1, end + 1);

            }

            // check end -1;
            if (isPalindrome(s, start, end - 1)) {
                return s.substring(start, end);
            }

            start++;
            end--;
        }

        return s;
    }
}
