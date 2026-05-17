package Strings;

import java.util.*;

public class Strings {

    // Find the largest word in a String
    // tc is o(n) sc is o(1)
    public static String largestWord(String s) {

        int maxLen = 0;
        int maxEnd = -1;
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ' ') {
                currLen++;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxEnd = i; // end of curr word is i
                }
            } else {
                currLen = 0; // new word begin
            }
        }

        if (maxEnd == -1) {
            return " ";
        }

        // end - start + 1, end + 1 is ans
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    // Write a program to sort characters in a string
    // tc is o(n^2) sc is o(n)
    public static String sortCharacters(String s) {

        char[] arr = s.toCharArray();

        int n = s.length();
        // bubble sort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        String ans = new String(arr);
        return ans;
    }

    // optimal using sort func tc is o(n log n) sc is o(n)
    public static String sortCharacters2(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        String ans = new String(arr);
        return ans;
    }

    // Count the number of words in a given string
    // tc is o(n) and sc is o(n)
    public static int countWords(String s) {

        String[] arr = s.split(" ");
        return arr.length;
    }

    // tc is o(n) sc is o(1)
    public static int countWords3(String s) {
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.print(largestWord("Microsoft Teams"));

    }
}