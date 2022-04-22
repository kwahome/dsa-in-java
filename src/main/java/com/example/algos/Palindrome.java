package com.example.algos;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    private static char SPACE_CHAR = ' ';

    public static boolean isPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);

            if (leftChar != rightChar && !(leftChar == SPACE_CHAR || rightChar == SPACE_CHAR)) {
                return false;
            }

            if (leftChar == SPACE_CHAR) {
                left++;

                continue;
            }

            if (rightChar == SPACE_CHAR) {
                right--;

                continue;
            }

            left++;

            right--;
        }

        return true;
    }

    /**
     * The problem differs from the problem of finding the longest palindromic
     * substring. Unlike substrings, subsequences are not required to occupy
     * consecutive positions within the original string.
     * 
     * @param input
     * @param ignoreSpaces
     * @return
     */
    public static String findLongestPalindromicSubsequence(String input) {

        // lookup[i][j] stores the length of LCS of substring `X[0…i-1]` and `Y[0…j-1]`
        int[][] lookup = new int[input.length() + 1][input.length() + 1];

        String reversed = new StringBuilder(input).reverse().toString();

        // calculate length of the longest palindromic subsequence first
        getLongestCommonPalindromicSubsequenceLength(input, reversed, input.length(), lookup);

        return findLongestPalindromicSubsequence(
                input,
                reversed,
                input.length(),
                input.length(),
                lookup);
    }

    /**
     * Returns the longest contiguous substring of a string that is also a
     * palindrome. For example, the longest palindromic substring of “bananas” is
     * “anana”, and the longest palindromic substring of “abdcbcdbdcbbc” is
     * “bdcbcdb”.
     * 
     * The dynamic programming solution for this problem takes O(n2) time and O(n2)
     * space. There is however another approach to solve this problem that doesn’t
     * require any extra space.
     * 
     * The idea is simple and effective – for each character in the given string,
     * consider it the midpoint of a palindrome and expand in both directions to
     * find the maximum length palindrome. For an even length palindrome, consider
     * every adjacent pair of characters as the midpoint.
     * 
     * @param input
     * @return
     */
    public static String findLongestPalindromicSubstring(String input) {

        if (input == null || input.length() == 0) {
            return input;
        }

        // `maxString` stores the maximum length palindromic substring
        // found so far

        String maxString = "", current;

        // `maxStringLength` stores the maximum length of palindromic
        // substring found so far

        int maxStringLength = 0, currentLength;

        // consider every character of the given string as a midpoint and expand
        // in both directions to find maximum length palindrome

        for (int i = 0; i < input.length(); i++) {
            // find the longest odd length palindrome with `str[i]` as a midpoint
            current = getPalindromicSubstring(input, i, i);
            currentLength = current.length();

            // update maximum length palindromic substring if odd length
            // palindrome has a greater length

            if (currentLength > maxStringLength) {
                maxString = current;
                maxStringLength = currentLength;
            }

            // Find the longest even length palindrome with str[i] and
            // str[i+1] as midpoints. Note that an even length palindrome
            // has two midpoints.
            current = getPalindromicSubstring(input, i, i + 1);
            currentLength = current.length();

            // update maximum length palindromic substring if odd length
            // palindrome has a greater length

            if (currentLength > maxStringLength) {
                maxString = current;
                maxStringLength = currentLength;
            }
        }

        return maxString;
    }

    /**
     * Returns the longest common subsequence given two strings.
     * 
     * @param string
     * @param reverse
     * @param length
     * @param lookup
     * @return
     */
    public static int getLongestCommonPalindromicSubsequenceLength(
            String string,
            String reverse,
            int length,
            int[][] lookup) {

        // Fill the lookup table in a bottom-up manner.
        // The first row and first column of the lookup table are already 0.
        for (int i = 1; i <= length; i++) {

            for (int j = 1; j <= length; j++) {

                // if current character of `X` and `Y` matches
                if (string.charAt(i - 1) == reverse.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }

                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        return lookup[length][length];
    }

    /**
     * A palindrome is essentially a symmetric string about
     * its mid point, we can compare the char at matching
     * positions.
     * 
     * There are two possibilities:
     * 
     * 1. If the string’s last character is the same as
     * the first character, no deletion is needed, and
     * we recur for the remaining substring X[i+1, j-1].
     * 
     * 2. If the last character of the string is different
     * from the first character, return one plus the
     * minimum of the two values we get by:
     * - Deleting the last character and recursing for the
     * remaining substring X[i, j-1].
     * - Deleting the first character and recursing for the
     * remaining substring X[i+1, j].
     * 
     * Time complexity = O(n^2)
     * Worst case = O(2^n)
     * Space complexity = O(n^2)
     * 
     * We can optimize the recursion with DP memoization
     * since solutions to sub-problems are recursively
     * computed. Memoization helps us to simply look
     * them up.
     * 
     * @param input
     * @return
     */
    public static Integer minDeletionsToPalindrome(String input, boolean ignoreSpaces) {

        int left = 0;
        int right = input.length() - 1;

        int deletions = 0;

        // create a map to store solutions to subproblems
        Map<String, Integer> lookup = new HashMap<>();

        if (left < right) {
            deletions = minDeletionsToPalindrome(input, left, right, lookup, ignoreSpaces);
        }

        return deletions;
    }

    private static String getPalindromicSubstring(String input, int low, int high) {
        // expand in both directions
        while (low >= 0 && high < input.length() &&
                (input.charAt(low) == input.charAt(high))) {
            low--;
            high++;
        }

        return input.substring(low + 1, high);
    }

    private static String findLongestPalindromicSubsequence(
            String input,
            String reverse,
            int inputLength,
            int reverseLength,
            int[][] lookup) {

        // return an empty string if the end of either sequence is reached
        if (inputLength == 0 || reverseLength == 0) {
            return "";
        }

        // If the last character of `X` and `Y` matches
        if (input.charAt(inputLength - 1) == reverse.charAt(reverseLength - 1)) {
            // append current character (`X[m-1]` or `Y[n-1]`) to LCS of
            // substring `X[0…m-2]` and `Y[0…n-2]`

            return findLongestPalindromicSubsequence(input, reverse, inputLength - 1, reverseLength - 1, lookup)
                    + input.charAt(inputLength - 1);
        }

        // otherwise, if the last character of `X` and `Y` are different

        // if a top cell of the current cell has more value than the left
        // cell, then drop the current character of string `X` and find LCS
        // of substring `X[0…m-2]`, `Y[0…n-1]`

        if (lookup[inputLength - 1][reverseLength] > lookup[inputLength][reverseLength - 1]) {
            return findLongestPalindromicSubsequence(input, reverse, inputLength - 1, reverseLength, lookup);
        }

        // if a left cell of the current cell has more value than the top
        // cell, then drop the current character of string `Y` and find LCS
        // of substring `X[0…m-1]`, `Y[0…n-2]`

        return findLongestPalindromicSubsequence(input, reverse, inputLength, reverseLength - 1, lookup);
    }

    private static int minDeletionsToPalindrome(
            String input,
            int leftIndex,
            int rightIndex,
            Map<String, Integer> lookup,
            boolean ignoreSpaces) {

        if (leftIndex >= rightIndex) {
            return 0;
        }

        // construct a unique map key from dynamic elements of the input
        String key = leftIndex + ":" + rightIndex;

        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }

        if (input.charAt(leftIndex) == input.charAt(rightIndex)) {
            // no deletions required
            // we move to the next sub string
            lookup.put(key, minDeletionsToPalindrome(input, leftIndex + 1, rightIndex - 1, lookup, ignoreSpaces));

            return lookup.get(key);
        }

        // otherwise, if the last character of the string is different from the
        // first character

        // if spaces are to be ignored
        if (ignoreSpaces && (input.charAt(leftIndex) == SPACE_CHAR || input.charAt(rightIndex) == SPACE_CHAR)) {
            if (input.charAt(leftIndex) == SPACE_CHAR) {
                leftIndex++;
            }

            if (input.charAt(rightIndex) == SPACE_CHAR) {
                rightIndex--;
            }

            lookup.put(key, minDeletionsToPalindrome(input, leftIndex, rightIndex, lookup, ignoreSpaces));

            return lookup.get(key);
        }

        // else any char is valid for deletion
        // 1. Remove the last character and recur for the remaining substring
        // 2. Remove the first character and recur for the remaining substring

        // return 1 (for remove operation) + minimum of the two values

        lookup.put(key, 1 + Math.min(minDeletionsToPalindrome(input, leftIndex, rightIndex - 1, lookup, ignoreSpaces),
                minDeletionsToPalindrome(input, leftIndex + 1, rightIndex, lookup, ignoreSpaces)));

        return lookup.get(key);
    }
}
