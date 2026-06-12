package NumberSystem;

public class NumberSystem {

    public static void main(String[] args) {

        System.out.print(decimalToBinary(18));

    }

    // convert Binary to Decimal
    // tc is O(1) sc is o(1)
    public static int binaryToDecimal(String s) {
        int num = Integer.parseInt(s, 2);
        return num;
    }

    // Convert Binary to Octal
    // tc is o(n) sc is o(n)
    public static String binaryToOctal(String s) {
        int n = s.length();
        if (n % 3 == 1) {
            s = "00" + s;
        } else if (n % 3 == 2) {
            s = "0" + s;
        }

        n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            int temp = (s.charAt(i) - '0') * 4
                    + (s.charAt(i + 1) - '0') * 2
                    + (s.charAt(i + 2) - '0');
            sb.append((char) (temp + '0'));
        }
        return sb.toString();
    }

    // Convert Decimal to Binary Number
    // tc is o(n) sc is o(n)
    public static int decimalToBinary(int num) {
        String s = Integer.toBinaryString(num);
        int ans = Integer.parseInt(s);
        return ans;
    }

    // Convert Decimal to Octal
    // tc is o(n) sc is o(n)
    public static int decimalToOctal(int num) {

        StringBuilder sb = new StringBuilder();
        int temp = num;
        while (temp != 0) {
            int rem = temp % 8;
            sb.append(rem);
            int quo = temp / 8;
            temp = quo;
        }
        String str = sb.reverse().toString();
        int ans = Integer.parseInt(str);
        return ans;
    }

    // Convert Octal to Binary
    // tc is o(n) sc is o(1)
    public static String octalToBinary(int num) {

        String s = Integer.toString(num);
        int n = s.length();
        StringBuilder sb = new StringBuilder(n * 3);
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 7) {
                return "";
            }
            String bin = Integer.toBinaryString(digit);
            for (int k = bin.length(); k < 3; k++) {
                sb.append('0');
            }
            sb.append(bin);
        }
        return sb.toString();
    }

    // Convert Octal to Decimal
    // tc is o(n) sc is o(1)
    public static int octalToDecimal(int num) {
        int sum = 0;
        int power = 1;
        String s = Integer.toString(num);
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int digit = (s.charAt(i) - '0');
            if (digit < 0 || digit > 7) {
                return -1;
            }
            sum += digit * power;
            power *= 8;
        }
        return sum;
    }

    // Convert digits/numbers to words
    // tc is o(n) sc is o(1)
    public static void convertNumIntoWord(String str) {
        // Words for single digits
        String[] singleDigit = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        // Words for numbers from 10 to 19
        String[] twoDigits = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };

        // Words for multiples of ten from 20 onwards
        String[] tensMultiple = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                "ninety" };

        // Words for higher powers
        String[] tensPower = { "hundred", "thousand" };

        // Handle empty input
        if (str.length() == 0) {
            System.out.println("");
            return;
        }

        // Handle single digit input
        else if (str.length() == 1) {
            System.out.println(singleDigit[str.charAt(0) - '0']);
            return;
        }

        // Store length of string
        int len = str.length();

        // Loop through each digit
        for (int i = 0; i < str.length(); i++) {
            // If more than two digits remain
            if (len > 2) {
                // Print digit and its place value if digit is not zero
                if (str.charAt(i) - '0' != 0) {
                    System.out.print(singleDigit[str.charAt(i) - '0'] + " ");
                    System.out.print(tensPower[len - 3] + " ");
                }
                len--;
            } else {
                // Handle numbers between 10 and 19
                if (str.charAt(i) - '0' == 1) {
                    System.out.print(twoDigits[str.charAt(i + 1) - '0'] + " ");
                    return;
                }
                // Handle multiples of 10 and following digit
                else if (str.charAt(i) - '0' != 0) {
                    System.out.print(tensMultiple[str.charAt(i) - '0'] + " ");
                    if (str.charAt(i + 1) - '0' != 0)
                        System.out.print(singleDigit[str.charAt(i + 1) - '0'] + " ");
                    return;
                }
            }
        }
    }
}
