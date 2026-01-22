class Solution {

    static final int MOD = 1000000007;
    Integer dp[][];

    public int countPartitions(int[] nums, int d) {

        int sum = 0;
        for (int x : nums) sum += x;

        if (sum - d < 0 || (sum - d) % 2 != 0)
            return 0;

        int target = (sum - d) / 2;

        dp = new Integer[nums.length][target + 1];

        return hlp(0, nums, target);
    }

    int hlp(int i, int[] nums, int t) {

    
        if (i == nums.length || t < 0) {
            return t == 0 ? 1 : 0;
        }

        if (dp[i][t] != null)
            return dp[i][t];

        int chose = hlp(i + 1, nums, t - nums[i]);
        int noch  = hlp(i + 1, nums, t);

        return dp[i][t] = (chose + noch) % MOD;
    }
}
