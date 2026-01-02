
public class IntegerToRoman {
    static void main() {
        System.out.println(intToRoman(400));
    }

    public static String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                ans.append('M');
            } else if (num >= 900) {
                num -= 900;
                ans.append("CM");
            } else if (num >= 500) {
                num -= 500;
                ans.append('D');
            } else if (num >= 400) {
                num -= 400;
                ans.append("CD");
            } else if (num >= 100) {
                num -= 100;
                ans.append('C');
            } else if (num >= 90) {
                num -= 90;
                ans.append("XC");
            } else if (num >= 50) {
                num -= 50;
                ans.append('L');
            } else if (num >= 40) {
                num -= 40;
                ans.append("XL");
            } else if (num >= 10) {
                num -= 10;
                ans.append('X');
            } else if (num == 9) {
                num -= 9;
                ans.append("IX");
            } else if (num == 8) {
                num -= 8;
                ans.append("VIII");
            } else if (num == 7) {
                num -= 7;
                ans.append("VII");
            } else if (num == 6) {
                num -= 6;
                ans.append("VI");
            } else if (num == 5) {
                num -= 5;
                ans.append('V');
            } else if (num == 4) {
                num -= 4;
                ans.append("IV");
            } else if (num == 3) {
                num -= 3;
                ans.append("III");
            } else if (num == 2) {
                num -= 2;
                ans.append("II");
            } else {
                num -= 1;
                ans.append('I');
            }
        }

        return ans.toString();
    }
}
