class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length == 0)
            return new int[0];
        int n = nums.length;
        
        int ans[] = new int[n-k+1];
        int idx = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < k; i++)
        {
            while( !q.isEmpty() && nums[i] >= nums[q.getLast()] )
                q.removeLast();
            
            q.addLast(i);
        }    
        
        ans[idx++] = nums[q.peek()];
        
        for(int i = k; i < n; i++)
        {
             while( !q.isEmpty() && q.peek() <= i-k  )
                q.removeFirst();
            
            while( !q.isEmpty() && nums[i] >= nums[q.getLast()] )
                q.removeLast();
        
           
            q.add(i);
            ans[idx++] = nums[q.peek()];
            
        }
        
        return ans;
    }
}