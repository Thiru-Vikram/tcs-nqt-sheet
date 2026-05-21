package Strings;

import java.util.*;

public class Strings {

    public static void main(String[] args) {

        System.out.print(removeVowels("I am very happy today"));

    }

    // Remove all vowels from the String
    // tc is o(n) sc is o(n)
    public static String removeVowels(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A' || c == 'i' || c == 'I' ||
                    c == 'e' || c == 'E' || c == 'o' || c == 'O' ||
                    c == 'u' || c == 'U') {
                continue;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Remove Spaces from a String
    // tc is o(n) sc is o(n)
    public static String removeSpaces(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Remove characters from a string except alphabets
    // tc is o(n) sc is o(n)
    public static String removeNonAlphabets(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Reverse a String
    // tc is o(n) sc is o(n)
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    // Remove brackets from an algebraic expression
    // tc is o(n) sc is o(n)
    public static String removeBrackets(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == ')') {
                continue;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Sum of the Numbers in a String
    // tc is o(n) sc is o(1)
    public static int sumOfNumbers(String s) {
        int sum = 0;
        String temp = "";

        // Traverse each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                temp += c; // Append digit
            } else {
                if (!temp.equals("")) {
                    sum += Integer.parseInt(temp);
                    temp = ""; // Reset
                }
            }
        }

        // Add last number if any
        if (!temp.equals("")) {
            sum += Integer.parseInt(temp);
        }

        return sum;
    }

    // Capitalize first and last character of each word of a string
    // tc is o(n) sc is o(n)
    public static String firstLastCharCapital(String s) {

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (word.isEmpty()) {
                continue;
            }

            String capitalized;
            if (word.length() == 1) {
                capitalized = word.toUpperCase();
            } else {
                String first = word.substring(0, 1).toUpperCase();
                String last = word.substring(word.length() - 1).toUpperCase();
                String middle = word.substring(1, word.length() - 1);
                capitalized = first + middle + last;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(capitalized);
        }
        return sb.toString();
    }

    // Calculate Frequency of characters in a String
    // tc is o(n) sc is o(1)
    public static void freqCount(String s) {
        int[] Freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Freq[i] != 0) {
                System.out.print((char) (i + 'a'));
                System.out.print(Freq[i] + " ");
            }
        }

    }

    // Find Non-repeating characters of a String
    // tc is o(n) sc is o(1)
    public static void nonRepeatingChar(String s) {

        int[] Freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (Freq[s.charAt(i) - 'a'] == 1) {
                System.out.print((char) (s.charAt(i) - 'a' + 'a'));
            }
        }
    }

    // check anagrams
    // tc is o(n) sc is o(1)
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            Freq[s1.charAt(i) - 'A']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            Freq[s2.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (Freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

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

}