class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream( nums ).sum();
        dp = new Boolean[sum/2 + 1][nums.length+1];
        return sum %2 != 0 ?  false : helper(nums, 0, sum/2);
    }
    
    boolean helper(int a[], int idx, int sum)
    {
        if(sum < 0)
            return false;
        if(sum == 0)
            return dp[sum][idx] = true;
        
        if(idx == a.length)
        {
            return dp[sum][idx] = (sum == 0);
        }
       
        if(dp[sum][idx] != null)
            return dp[sum][idx];
        
        boolean res = false;
        res = res || helper( a, idx+1, sum-a[idx]);
        res = res || helper( a, idx+1, sum );
        return dp[sum][idx] = res;
        
    }
}
