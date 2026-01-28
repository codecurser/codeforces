class Solution {

    Integer[][] dp;

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new Integer[n][m];
        int lcs = helper(0, 0, word1, word2);

        return (n - lcs) + (m - lcs);
    }

    int helper(int i, int j, String s1, String s2) {

        if (i == s1.length() || j == s2.length())
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + helper(i + 1, j + 1, s1, s2);
        } else {
            dp[i][j] = Math.max(
                    helper(i + 1, j, s1, s2),
                    helper(i, j + 1, s1, s2)
            );
        }

        return dp[i][j];
    }
}
