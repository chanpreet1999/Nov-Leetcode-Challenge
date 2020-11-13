class Solution {
    Set<List<Integer>> hs;
    public List<List<Integer>> permuteUnique(int[] nums) {
        
         if( nums.length == 0 )
            return new ArrayList<>();
        
        hs = new HashSet<>();
        
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        Arrays.sort( nums );
        
        helper( nums, 0, new boolean[ nums.length ], smallAns, ans );
        
        return ans;
    }
    
    void helper( int nums[], int count, boolean vis[], List<Integer> smallAns, List<List<Integer>> ans)
    {
        if(count == nums.length)
        {
            if( !hs.contains(smallAns) )
            {
                List<Integer> temp = new ArrayList<>(smallAns);
                ans.add( temp );
                hs.add( smallAns );
            }
            return;
        }
        
        
        int prev = -(int)1e8;
        for(int i = 0;i < nums.length; i++)
        {
            
            if( !vis[i] && prev != nums[i] )
            {
                vis[i] = true;
                smallAns.add(nums[i]);
                
                helper( nums, count+1, vis, smallAns, ans );
                
                vis[i] = false;
                smallAns.remove( smallAns.size()-1 );
                prev = nums[i];
            }
        }
    }
}