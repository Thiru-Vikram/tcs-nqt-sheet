package NumberSystem;

public class NumberSystem {

    public static void main(String[] args) {

        System.out.print(octalToDecimal(170));

    }

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
