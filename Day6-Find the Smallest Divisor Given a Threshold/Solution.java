class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int n = nums.length, max = -1;
        
        for(int ele : nums)
        {
            if(ele > max)
                max = ele;
        }
        
        int ans = max;
        int l = 1, h = max;
        
        
        while(l < h)
        {
            int mid = ( (h-l) >> 1) + l;
            if( calcCost( nums, mid ) <= threshold )
            {
                ans = mid;
                h = mid;
            }
            else
            {
                l = mid+1;
            }
        }
        return ans;
    }
    
    int calcCost( int a[], int x )
    {
        int ans = 0;
        
        for(int ele : a )
        {
            ans += (ele + x -1)/x;
        }
        return ans;
    }
}