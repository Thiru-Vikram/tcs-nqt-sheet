package Strings;

import java.util.*;

public class Strings {

    // Maximum occurring character in a string
    // tc is o(n) sc is o(1)
    public static Character maxChar(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            }
        }

        int maxFreq = 0;
        int maxIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > maxFreq) {
                maxFreq = arr[i];
                maxIndex = i;
            }
        }
        return (char) (maxIndex + 'a');
    }

    // Remove All Duplicates from a String
    // tc is o(n) sc is o(1)
    public static String removeDuplicates(String s) {
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Print all duplicates char with counts in a string
    // tc is o(n) sc is o(1)
    public static void duplicateChars(String s) {

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 1) {
                System.out.println((char) (i + 'a') + " : " + arr[i]);
            }
        }
    }

    // Remove Characters from first String not present in the Second String
    // tc is o(n + m) sc is o(n + m)
    public static String removeString(String s1, String s2) {

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            set.add(s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (!set.contains(s1.charAt(i))) {
                sb.append(s1.charAt(i));
            }
        }
        return sb.toString();
    }

    // Change every letter with next lexicographic alphabet
    // tc is o(n) sc is o(1)
    public static String changeLetters(String str) {
        int n = str.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch; // Get ASCII value

            if (ascii == 90) // If 'Z', wrap to 'A'
                result.append((char) 65);
            else if (ascii == 122) // If 'z', wrap to 'a'
                result.append((char) 97);
            else if ((ascii >= 65 && ascii < 90) || (ascii >= 97 && ascii < 122))
                result.append((char) (ascii + 1)); // Shift to next character
            else
                result.append(ch); // Leave other characters unchanged
        }

        return result.toString();
    }

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

        duplicateChars("sinstriiintng");

    }
}