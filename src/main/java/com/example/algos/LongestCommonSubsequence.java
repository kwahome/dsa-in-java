package com.example.algos;

public class LongestCommonSubsequence {

    /**
     * Returns the longest common subsequence given two strings.
     * 
     * @param stringA
     * @param stringB
     * @param n
     * @param lookup
     * @return
     */
    public static int getLongestCommonSubstring(
            String stringA,
            String stringB,
            int n,
            int[][] lookup) {

        // Fill the lookup table in a bottom-up manner.
        // The first row and first column of the lookup table are already 0.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // if current character of `X` and `Y` matches
                if (stringA.charAt(i - 1) == stringB.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }

                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        return lookup[n][n];
    }
}
